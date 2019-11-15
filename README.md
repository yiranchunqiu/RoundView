### 介绍
# 自用项目，自定义圆形圆环圆角控件（LinearLayout，RelativeLayout，TextView）

```
### 图片
<div style="align: center">
       <img src="https://github.com/yiranchunqiu/roundview/blob/master/pic/%E5%9B%BE%E7%89%871.png" width="32%">
       <img src="https://github.com/yiranchunqiu/roundview/blob/master/pic/%E5%9B%BE%E7%89%872.png" width="32%">
</div>

```

### 使用方法
# 添加
#
allprojects {
 		repositories {
 			maven { url 'https://jitpack.io' }
 		}
 	}
# 添加依赖
#
 	dependencies {
    	        implementation 'com.github.yiranchunqiu:roundview:1.0'
    	}
# 使用
#
<com.pxz.pxzroundview.RoundTextView
                android:layout_width="match_parent"
                android:layout_height="50dp"
                android:layout_marginLeft="50dp"
                android:layout_marginTop="20dp"
                android:layout_marginRight="50dp"
                android:layout_marginBottom="20dp"
                android:gravity="center"
                android:text="可点击按钮"
                android:textColor="@color/white"
                android:textSize="20sp"
                app:is_selector="true"
                app:no_color="@color/green"
                app:radius="10dp"
                app:yes_color="@color/gray" />

```

### 属性
名称 | 描述 |  默认值
---|---|---
is_selector | 是否有按压状态 | false
left_top_radius | 左上圆角 | 0
left_bottom_radius | 左下圆角 | 0
right_top_radius | 右上圆角 | 0
right_bottom_radius | 右下圆角 | 0
radius | 圆角 | 0
no_color | 默认状态下的背景颜色 | white
no_stroke_color | 默认状态下的边框颜色 | transparent
yes_color | 点击状态下的背景颜色 | white
yes_stroke_color | 点击状态下的边框颜色 | transparent
enabled_color | 不可点击状态下的背景颜色 | white
enabled_stroke_color | 不可点击状态下的边框颜色 | transparent
stroke_line_width | 边框宽度 | 0