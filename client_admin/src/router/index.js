import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue';
import login from '../views/login.vue';
import forgot from '../views/forgot.vue';
Vue.use(VueRouter)

const routes = [
	// 主页
	{
		path: '/',
		name: 'index',
		component: index,
		meta: {
			index: 0,
			title: '首页'
		}
	},

	// 登录
	{
		path: '/login',
		name: 'login',
		component: login,
		meta: {
			index: 0,
			title: '登录'
		}
	},


	// 忘记密码
	{
		path: '/forgot',
		name: "forgot",
		component: forgot,
		meta: {
			index: 0,
			title: '忘记密码'
		}
	},

	// 修改密码
	{
		path: '/user/password',
		name: "password",
		component: () => import("../views/user/password.vue"),
		meta: {
			index: 0,
			title: '修改密码'
		}
	},

	// 视频播放页
	{
		path: "/media/video",
		name: "video",
		component: () => import('../views/media/video.vue'),
		meta: {
			index: 0,
			title: "视频"
		}
	},

	// 音频播放页
	{
		path: "/media/audio",
		name: "audio",
		component: () => import('../views/media/audio.vue'),
		meta: {
			index: 0,
			title: "音频"
		}
	},



	// 友情链接路由
	// {
	// 	path: '/link/table',
	// 	name: 'link_table',
	// 	component: () => import('../views/link/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接列表'
	// 	}
	// },
	// {
	// 	path: '/link/view',
	// 	name: 'link_view',
	// 	component: () => import('../views/link/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接详情'
	// 	}
	// },

	// 轮播图路由
	{
		path: '/slides/table',
		name: 'slides_table',
		component: () => import('../views/slides/table.vue'),
		meta: {
			index: 0,
			title: '轮播图列表'
		}
	},
	{
		path: '/slides/view',
		name: 'slides_view',
		component: () => import('../views/slides/view.vue'),
		meta: {
			index: 0,
			title: '轮播图详情'
		}
	},
	
	// 广告路由
	// {
	// 	path: '/ad/table',
	// 	name: 'ad_table',
	// 	component: () => import('../views/ad/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告列表'
	// 	}
	// },
	// {
	// 	path: '/ad/view',
	// 	name: 'ad_view',
	// 	component: () => import('../views/ad/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告详情'
	// 	}
	// },



	// 公告路由
	{
		path: '/notice/table',
		name: 'notice_table',
		component: () => import('../views/notice/table.vue'),
		meta: {
			index: 0,
			title: '公告列表'
		}
	},
	{
		path: '/notice/view',
		name: 'notice_view',
		component: () => import('../views/notice/view.vue'),
		meta: {
			index: 0,
			title: '公告详情'
		}
	},


	// 评论路由
	{
		path: '/comment/table',
		name: 'comment_table',
		component: () => import('../views/comment/table.vue'),
		meta: {
			index: 0,
			title: '评论列表'
		}
	},
	{
		path: '/comment/view',
		name: 'comment_view',
		component: () => import('../views/comment/view.vue'),
		meta: {
			index: 0,
			title: '评论详情'
		}
	},

	// 供货商路由
	{
		path: '/supplier/table',
		name: 'supplier_table',
		component: () => import('../views/supplier/table.vue'),
		meta: {
			index: 0,
			title: '供货商列表'
		}
	},
	{
		path: '/supplier/view',
		name: 'supplier_view',
		component: () => import('../views/supplier/view.vue'),
		meta: {
			index: 0,
			title: '供货商详情'
		}
	},
	// 普通用户路由
	{
		path: '/ordinary_users/table',
		name: 'ordinary_users_table',
		component: () => import('../views/ordinary_users/table.vue'),
		meta: {
			index: 0,
			title: '普通用户列表'
		}
	},
	{
		path: '/ordinary_users/view',
		name: 'ordinary_users_view',
		component: () => import('../views/ordinary_users/view.vue'),
		meta: {
			index: 0,
			title: '普通用户详情'
		}
	},
	// 商品信息路由
	{
		path: '/product_information/table',
		name: 'product_information_table',
		component: () => import('../views/product_information/table.vue'),
		meta: {
			index: 0,
			title: '商品信息列表'
		}
	},
	{
		path: '/product_information/view',
		name: 'product_information_view',
		component: () => import('../views/product_information/view.vue'),
		meta: {
			index: 0,
			title: '商品信息详情'
		}
	},
	// 商品类型路由
	{
		path: '/product_type/table',
		name: 'product_type_table',
		component: () => import('../views/product_type/table.vue'),
		meta: {
			index: 0,
			title: '商品类型列表'
		}
	},
	{
		path: '/product_type/view',
		name: 'product_type_view',
		component: () => import('../views/product_type/view.vue'),
		meta: {
			index: 0,
			title: '商品类型详情'
		}
	},
	// 预约订单路由
	{
		path: '/appointment_order/table',
		name: 'appointment_order_table',
		component: () => import('../views/appointment_order/table.vue'),
		meta: {
			index: 0,
			title: '预约订单列表'
		}
	},
	{
		path: '/appointment_order/view',
		name: 'appointment_order_view',
		component: () => import('../views/appointment_order/view.vue'),
		meta: {
			index: 0,
			title: '预约订单详情'
		}
	},
	// 收货记录路由
	{
		path: '/receiving_records/table',
		name: 'receiving_records_table',
		component: () => import('../views/receiving_records/table.vue'),
		meta: {
			index: 0,
			title: '收货记录列表'
		}
	},
	{
		path: '/receiving_records/view',
		name: 'receiving_records_view',
		component: () => import('../views/receiving_records/view.vue'),
		meta: {
			index: 0,
			title: '收货记录详情'
		}
	},
	// 售后申请路由
	{
		path: '/after_sales_application/table',
		name: 'after_sales_application_table',
		component: () => import('../views/after_sales_application/table.vue'),
		meta: {
			index: 0,
			title: '售后申请列表'
		}
	},
	{
		path: '/after_sales_application/view',
		name: 'after_sales_application_view',
		component: () => import('../views/after_sales_application/view.vue'),
		meta: {
			index: 0,
			title: '售后申请详情'
		}
	},
	// 售后结果路由
	{
		path: '/after_sales_results/table',
		name: 'after_sales_results_table',
		component: () => import('../views/after_sales_results/table.vue'),
		meta: {
			index: 0,
			title: '售后结果列表'
		}
	},
	{
		path: '/after_sales_results/view',
		name: 'after_sales_results_view',
		component: () => import('../views/after_sales_results/view.vue'),
		meta: {
			index: 0,
			title: '售后结果详情'
		}
	},
	// 直播预约路由
	{
		path: '/live_booking/table',
		name: 'live_booking_table',
		component: () => import('../views/live_booking/table.vue'),
		meta: {
			index: 0,
			title: '直播预约列表'
		}
	},
	{
		path: '/live_booking/view',
		name: 'live_booking_view',
		component: () => import('../views/live_booking/view.vue'),
		meta: {
			index: 0,
			title: '直播预约详情'
		}
	},
	// 咨询记录路由
	{
		path: '/consultation_records/table',
		name: 'consultation_records_table',
		component: () => import('../views/consultation_records/table.vue'),
		meta: {
			index: 0,
			title: '咨询记录列表'
		}
	},
	{
		path: '/consultation_records/view',
		name: 'consultation_records_view',
		component: () => import('../views/consultation_records/view.vue'),
		meta: {
			index: 0,
			title: '咨询记录详情'
		}
	},
	// 回复记录路由
	{
		path: '/reply_record/table',
		name: 'reply_record_table',
		component: () => import('../views/reply_record/table.vue'),
		meta: {
			index: 0,
			title: '回复记录列表'
		}
	},
	{
		path: '/reply_record/view',
		name: 'reply_record_view',
		component: () => import('../views/reply_record/view.vue'),
		meta: {
			index: 0,
			title: '回复记录详情'
		}
	},
	// 取消订单路由
	{
		path: '/cancellation_of_order/table',
		name: 'cancellation_of_order_table',
		component: () => import('../views/cancellation_of_order/table.vue'),
		meta: {
			index: 0,
			title: '取消订单列表'
		}
	},
	{
		path: '/cancellation_of_order/view',
		name: 'cancellation_of_order_view',
		component: () => import('../views/cancellation_of_order/view.vue'),
		meta: {
			index: 0,
			title: '取消订单详情'
		}
	},
	// 取消确认路由
	{
		path: '/cancel_confirmation/table',
		name: 'cancel_confirmation_table',
		component: () => import('../views/cancel_confirmation/table.vue'),
		meta: {
			index: 0,
			title: '取消确认列表'
		}
	},
	{
		path: '/cancel_confirmation/view',
		name: 'cancel_confirmation_view',
		component: () => import('../views/cancel_confirmation/view.vue'),
		meta: {
			index: 0,
			title: '取消确认详情'
		}
	},

	// 用户路由
	{
		path: '/user/table',
		name: 'user_table',
		component: () => import('../views/user/table.vue'),
		meta: {
			index: 0,
			title: '用户列表'
		}
	},
	{
		path: '/user/view',
		name: 'user_view',
		component: () => import('../views/user/view.vue'),
		meta: {
			index: 0,
			title: '用户详情'
		}
	},
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue'),
		meta: {
			index: 0,
			title: '个人信息'
		}
	},
	// 用户组路由
	{
		path: '/user_group/table',
		name: 'user_group_table',
		component: () => import('../views/user_group/table.vue'),
		meta: {
			index: 0,
			title: '用户组列表'
		}
	},
	{
		path: '/user_group/view',
		name: 'user_group_view',
		component: () => import('../views/user_group/view.vue'),
		meta: {
			index: 0,
			title: '用户组详情'
		}
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.beforeEach((to, from, next) => {
	let token = to.query.token;
	if (token){
		$.db.set("token",token,120);
	}
	next();
})

router.afterEach((to, from, next) => {
	let title = "供货服务平台小程序-admin";
	document.title = title;
})

export default router
