<template>
	<view class="page_live_booking diy_detail diy_detail--new" id="live_booking_details">
		<view class="warp">
			<view class="container-fluid">
				<view class="row">
					<view v-if="$check_field('get','trade_name')" class="col-12 col-6">
						<view class="view">
							<view class="diy_title">
								<span>商品名称</span>
							</view>
								<view class="diy_field diy_text">
								<span>
									{{ obj["trade_name"] }}
								</span>
							</view>
							</view>
					</view>
					<view v-if="$check_field('get','product_type')" class="col-12 col-6">
						<view class="view">
							<view class="diy_title">
								<span>商品类型</span>
							</view>
								<view class="diy_field diy_text">
								<span>
									{{ obj["product_type"] }}
								</span>
							</view>
							</view>
					</view>
					<view v-if="$check_field('get','product_parameters')" class="col-12 col-6">
						<view class="view">
							<view class="diy_title">
								<span>商品参数</span>
							</view>
								<view class="diy_field diy_text">
								<span>
									{{ obj["product_parameters"] }}
								</span>
							</view>
							</view>
					</view>
					<view v-if="$check_field('get','specifications')" class="col-12 col-6">
						<view class="view">
							<view class="diy_title">
								<span>规格</span>
							</view>
								<view class="diy_field diy_text">
								<span>
									{{ obj["specifications"] }}
								</span>
							</view>
							</view>
					</view>
					<view v-if="$check_field('get','price')" class="col-12 col-6">
						<view class="view">
							<view class="diy_title">
								<span>价格</span>
							</view>
								<view class="diy_field diy_text">
								<span>
									{{ obj["price"] }}
								</span>
							</view>
							</view>
					</view>
					<view v-if="$check_field('get','supplier_user')" class="col-12 col-6">
						<view class="view">
							<view class="diy_title">
								<span>供货商用户</span>
							</view>
								<view class="diy_field diy_uid">
								{{ get_user_supplier_user(obj['supplier_user']) }}
							</view>
							</view>
					</view>
					<view v-if="$check_field('get','supplier_name')" class="col-12 col-6">
						<view class="view">
							<view class="diy_title">
								<span>供货商名</span>
							</view>
								<view class="diy_field diy_text">
								<span>
									{{ obj["supplier_name"] }}
								</span>
							</view>
							</view>
					</view>
					<view v-if="$check_field('get','user_name')" class="col-12 col-6">
						<view class="view">
							<view class="diy_title">
								<span>用户名称</span>
							</view>
								<view class="diy_field diy_uid">
								{{ get_user_user_name(obj['user_name']) }}
							</view>
							</view>
					</view>
					<view v-if="$check_field('get','time_of_appointment')" class="col-12 col-6">
						<view class="view">
							<view class="diy_title">
								<span>预约时间</span>
							</view>
								<view class="diy_field diy_datetime">
								<span>
									{{ $toTime(obj["time_of_appointment"],"yyyy-MM-dd hh:mm:ss") }}
								</span>
							</view>
							</view>
					</view>
					<view v-if="$check_field('get','live_streaming_plan')" class="col-12 col-6">
						<view class="view">
							<view class="diy_title">
								<span>直播计划</span>
							</view>
								<view class="diy_field diy_desc">
								<span>
									{{ obj["live_streaming_plan"] }}
								</span>
							</view>
							</view>
					</view>
					<view v-if="$check_field('get','live_remarks')" class="col-12 col-6">
						<view class="view">
							<view class="diy_title">
								<span>直播备注</span>
							</view>
								<view class="diy_field diy_desc">
								<span>
									{{ obj["live_remarks"] }}
								</span>
							</view>
							</view>
					</view>
				</view>
			</view>
		</view>




		<view class="warp">
			<view class="container-fluid container-fluid-comment--new">
				<view class="row">
					<view class="col">

<!--						<button type="button" class="btn btn-primary" @click="cancel()">返回</button>-->





					</view>
				</view>
			</view>
		</view>


	</view>
</template>

<script>
	import list_comment from "@/components/diy/list_comment.vue";
	import bar_title from "@/components/diy/bar_title.vue";
	import form_editor from "@/components/diy/form_editor.vue";

	import mixin from "@/libs/mixins/page.js";
	export default {
		mixins: [mixin],
		components: {
			list_comment,
			bar_title,
			form_editor
		},
		data() {
			return {
				url_get_obj: "~/api/live_booking/get_obj?",
				field: "live_booking_id",
				query: {
					"live_booking_id": 0
				},
				// 商品详情初始化
				obj: {
						"trade_name": "",
							"product_type": "",
							"product_parameters": "",
							"specifications": "",
							"price": "",
							"supplier_user": 0,
							"supplier_name": "",
							"user_name": 0,
							"time_of_appointment": "",
							"live_streaming_plan": "",
							"live_remarks": "",
						"live_booking_id": 0,

				},
				// 点赞
				praise: 0,
				// 点赞状态
				state_praise: false,
				// 收藏
				collect: 0,
				// 收藏状态
				state_collect: false,
				// 评论列表初始化
				list_comment: [],
				// 评论bar标题
				bar_title: "评论区",
				// 评论bar的链接
				bar_url: "",
										// 用户列表
				list_user_supplier_user: [],
							// 用户列表
				list_user_user_name: [],
							}
		},
		methods: {
			openUrl(url) {
				console.log(1111)
				uni.navigateTo({
					url:`/pages/webview/webview?url=${url}`
				})
			},




			/**
			 * 获取对象之后
			 * @param {Object} json 结果对象
			 */
			get_obj_after(json) {
				// 判断是否获取到数据
				if (this.obj) {
					var obj = this.obj;
				}
			},

									/**
			 * 获取供货商用户列表
			 */
			async get_list_user_supplier_user() {
				var json = await this.$get("~/api/user/get_list?user_group=供货商");
				if(json.result && json.result.list){
					this.list_user_supplier_user = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_supplier_user(id){
				let obj = this.list_user_supplier_user;
				let ret = "";
				for(let i=0;i<obj.length;i++){
					if(obj[i].user_id==id){
						ret = obj[i].nickname+"-"+obj[i].username;
					}
				}
				return ret;
			},
						/**
			 * 获取普通用户用户列表
			 */
			async get_list_user_user_name() {
				var json = await this.$get("~/api/user/get_list?user_group=普通用户");
				if(json.result && json.result.list){
					this.list_user_user_name = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_user_name(id){
				let obj = this.list_user_user_name;
				let ret = "";
				for(let i=0;i<obj.length;i++){
					if(obj[i].user_id==id){
						ret = obj[i].nickname+"-"+obj[i].username;
					}
				}
				return ret;
			},
						},
		created() {
									this.get_list_user_supplier_user();
						this.get_list_user_user_name();
						},
		mounted() {
		},
	}

</script>

<style>
	.page_goods {
		padding-bottom: 3rem;
	}

	.link {
		text-align: center;
		padding: 0.5rem 0;
		border: 1px solid #DBDBDB;
		border-radius: 0.5rem;
	}

	.buy_wrap {
		position: fixed;
		bottom: 0;
		left: 0;
		width: 100%;
	}

	.dialog {
		width: 100%;
		height: 100vh;
		background: rgba(0, 0, 0, 0.5);
		z-index: 999;
		position: fixed;
		left: 0;
		top: 0;
		padding: 20vh 0;
	}

	.dialog-content {
		width: 500upx;
		height: 60vh;
		margin: 0 auto;
		background: #FFF;
		border-radius: 10upx;
		overflow: hidden;
		position: relative;
		display: flex;
		flex-direction: column;
		padding:  5vh;
		text-align: center;

	}
	.dialog-content span{
		margin-top:  3vh;
		}

	.dialog-close {
		width: 40upx;
		height: 40upx;
		border-radius: 20upx;
		position: absolute;
		right: 10upx;
		top: 10upx;
		font-size: 26upx;
		line-height: 40upx;
		text-align: center;
	}

	.dialog-list {
		padding: 40upx 20upx;
	}

	scroll-view {
		width: 100%;
		height: 100%;
	}

	.show-dialog {
		animation: 100ms showDialog linear forwards;
	}

	.hide-dialog {
		animation: 100ms hideDialog linear forwards;
	}

	@keyframes hideDialog {
		0% {
			opacity: 1;
		}


		100% {
			opacity: 0;
		}
	}

	@keyframes showDialog {
		0% {
			opacity: 0;
		}


		100% {
			opacity: 1;
		}
	}

	/* new style start */
	.diy_detail--new{
		padding: 5px;
	}
	.diy_detail--new .view {
		border-bottom: 1px solid #ccc;
		padding: 8px 0 ;
	}
	.diy_detail--new .view uni-view{
		display: inline-block;
	}
	.diy_detail--new .view .diy_title{
		color: var(--color_primary);
		margin-right: 5px;
		vertical-align: top;
	}
	.diy_detail--new .view .diy_img img{
		width: 100%;
	}
	.diy_detail--new .view .diy_music{
		vertical-align: text-top;
	}
	.diy_detail--new .bar_title{
		position: relative;
		background-color: #fff;
		display: flex;
		justify-content: space-between;
		align-items: center;
		margin-bottom: 2px;
		background: var(--color_primary);
		border-radius: 10px;
		height: 46px;
	}
	.diy_detail--new .bar_title .title{
		margin: 0 auto;
		color: var(--color_white);
		font-weight: 600;
	}
	.diy_detail--new .container-fluid-comment--new{
		margin: 10px 0.6rem;
	}
	.diy_detail--new .container-fluid-comment--new .col{
		display: flex;
		flex: auto;
		flex-wrap: wrap;
		flex-direction: row;
		margin-left: -10px;
	}
	.diy_detail--new .container-fluid-comment--new .btn{
		display: inline-block;
		border: none;
		background: var(--color_primary);
		color: #fff;
		font-size: 16px !important;
		padding: 2px 12px !important;
		border-radius: 20px;
		line-height: inherit;
		margin-bottom: 5px;
		margin-left: 10px;
		margin-right: 0;
	}
	.diy_detail--new .container-fluid-comment--new .btn:after{
		display: none;
	}
	.diy_detail--new .container-fluid-comment--new .btn .uni-icons{
		color: #fff !important;
	}
	.diy_detail--new .comment_title{
		margin-top: 10px;
	}
	/* new style end */

</style>
