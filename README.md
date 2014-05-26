本项目实现了一个可以从屏幕底部滑入的组件KCSlideFloatView，和如何使用的demo。

API 
public class KCSlideFloatView
extends Dialog

class overview

通过创建这个类可以实现从屏幕底部滑入对话框的功能

public method：


void open（）

打开底部对话框

void close（）

关闭底部对话框

void setView（View view）

设置对话框内容

void setFullScreen（boolean isFullScreen）

设置对话框是否全屏，默认的对话框右上角有个关闭的按钮，如果设置为全屏的话，关闭的按钮便会消失

void setPercentHeight （float percentHeight）

设置对话框的高度占全屏幕的百分比，如60%，参数则是0.6

void setScaleValue（float scaleValue）

当对话框出现的时候，后面屏幕会有个缩放的效果，此方法可以设置缩放的系数，1.0代表没有缩放



Demo 说明：

在主屏幕中间有个写着“Helloworld”的button， 点击button就可以看到底部对话框的效果。

