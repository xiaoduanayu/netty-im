### 主要内容
netty-im项目实现了一个简单的聊天室功能，支持单聊和群聊，心跳和空闲检测等功能。
### 主要知识点
- channel,channelHandler,channelHandlerContext,pipeline之间的关系如图

![1](images/channel与pipeline.jpg)
- @Sharable与单例模式

注意到[NettyServer](http://)中有一部分handler使用了单例模式（比如`PacketCodecHandler.INSTANCE`），并且在单例类上加了@Sharable注解，
这么做好的处就是每当一个客户端连接请求过来时，都使用同一个handler实例进行处理，以便节省开销，提高性能。这就要求作为单例的handler本身是无状态的，
比如该handler并不会存储与channel相关的信息（如输入输出流数据），以及没有有状态的成员变量等。比如`ImIdleStateHandler`和`PacketHander`就不能
修改为单例模式，因为它们都是有状态的。
如果把`PacketCodecHandler`的父类改成`ByteToMessageCodec`，那么`PacketCodecHandler`也不能修改为单例模式，因为`ByteToMessageCodec`中会存储
了与channel相关的流数据。
- 合并平行handler

在[NettyServer](http://)中用了一个[HandlerAggregator](http://)将7个平行的handler聚合到了一起，每次只调用一个handler，这样就避免了每次客户端
请求过来时，都要在pipeline中的inbound handler链中完整走一遍，从而提高了效率。平行handler有个特点，就是它们之间是平行关系，每次只会调用一个handler
不存在某一个handler是另一个handler的上游或者下游处理器。
- ctx.writeAndFlush()与ctx.channel().writeAndFlush()

假设handler加入pipeline的顺序依次为InboundHandler_A → InboundHandler_B → OutboundHandler_A → InboundHandler_C → OutboundHandler_B → OutboundHandler_C
那么，inbound message的流入顺序将是InboundHandler_A → InboundHandler_B → InboundHandler_C，outbound message的流出顺序将是
OutboundHandler_C → OutboundHandler_B → OutboundHandler_A
当InboundHandler_C调用`ctx.channel().writeAndFlush()`时，outbound handler的调用顺序将是OutboundHandler_C → OutboundHandler_B → OutboundHandler_A
当InboundHandler_C调用`ctx.writeAndFlush()`时，将只有OutboundHandler_A会被调用。