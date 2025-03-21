<template>
	<view class="diy_details diy_div_appointment_order">
		<view v-if="Object.keys(obj).length!==0" class="warp">
			<view class="container">
				<view class="row">
					<view v-if="$check_field('get','order_number')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>订单号:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["order_number"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','trade_name')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>商品名称:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["trade_name"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','product_type')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>商品类型:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["product_type"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','product_parameters')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>商品参数:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["product_parameters"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','specifications')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>规格:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["specifications"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','supplier_user')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>供货商用户:</span>
						</view>
							<view class="diy_field diy_uid">
							<text>
								{{ get_user_supplier_user(obj['supplier_user']) }}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','supplier_name')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>供货商名:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["supplier_name"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','price')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>价格:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["price"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','order_quantity')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>订购数量:</span>
						</view>
							<view class="diy_field diy_number">
							<text>
								{{ obj["order_quantity"] }}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','order_amount')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>订购金额:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["order_amount"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','whether_to_identify')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>是否鉴定:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["whether_to_identify"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','appraisal_fees')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>鉴定费用:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["appraisal_fees"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','total_amount')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>总金额:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["total_amount"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','user_name')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>用户名称:</span>
						</view>
							<view class="diy_field diy_uid">
							<text>
								{{ get_user_user_name(obj['user_name']) }}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','pickup_method')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>取货方式:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["pickup_method"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','consignee')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>收货人:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["consignee"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','receiving_phone_number')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>收货电话:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["receiving_phone_number"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','shipping_address')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>收货地址:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["shipping_address"]}}
							</text>
						</view>
						</view>
				</view>
			</view>
		</view>

			<view class="warp">
			<view class="container">
				<view class="row">
					<view class="col">
						<button type="button" class="diy_btn" @click="to_form('/pages/receiving_records/edit')" v-if="$check_action('/receiving_records/edit','add') || $check_action('/receiving_records/edit','set')" >收货确认</button>
					</view>
				</view>
			</view>
		</view>
			<view class="warp">
			<view class="container">
				<view class="row">
					<view class="col">
						<button type="button" class="diy_btn" @click="to_form('/pages/cancellation_of_order/edit')" v-if="$check_action('/cancellation_of_order/edit','add') || $check_action('/cancellation_of_order/edit','set')" >取消订单</button>
					</view>
				</view>
			</view>
		</view>
		</view>
</template>

<script>
	import mixin from "@/libs/mixins/component.js";
	export default {
		mixins: [mixin],
		props: {
			obj_goods: {
				type: Object,
				default(){
					return {}
				}
			},
			query:{
				type: Object,
				default(){
					return {
						appointment_order_id: 0
					}
				}
			}
		},
		data() {
			return {
				obj_goods_type: {},
				obj: {},
										// 用户列表
				list_user_supplier_user: [],
													// 用户列表
				list_user_user_name: [],
								}
		},
		methods: {
			async get_obj_goods_type() {
				var res = await this.$get("~/api/goods_type/get_obj", {
					name: this.obj_goods.type
				})

				if (res.result.obj) {
					this.obj_goods_type = res.result.obj
				} else {
					console.log("没有请求到商品分类");
				}
			},
			async get_obj_by_goods() {
				var {
					source_table,
					source_field
				} = this.obj_goods_type
				var {
					source_id
				} = this.obj_goods
				var query = {}
				query[source_field] = source_id
				this.$get("~/api/" + source_table + "/get_obj", {}, (res) => {
					if (res.result.obj) {
						this.obj = res.result.obj
					} else {
						console.log("没有请求到商品分类");
					}
				})
			},
			async get_obj_by_id(){
				var res = await this.$get("~/api/appointment_order/get_obj", {
					appointment_order_id:this.query.appointment_order_id
				})

				if (res.result && res.result.obj) {
					this.obj = res.result.obj
				} else {
					console.log("没有请求到商品分类");
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
		async onLoad(){
			if (Object.keys(this.obj_goods).length !== 0) {
				await this.get_obj_goods_type();
				await this.get_obj_by_goods();
			} else if (this.query["appointment_order_id"] !==0) {
				await this.get_obj_by_id();
			}
		}
	}
</script>

<style scoped>
	.div_appointment_order_details {}

	.details {
		background-color: #fff;
		margin-bottom: 0.5rem;
		padding: 1rem;
		font-size: 10px;
	}

	.item {
		display: flex;
		padding: 0.2rem 0;
		border-bottom: 1px solid #eee;
	}

	.left_text {
		flex: 0 0 25%;
	}

	.right_text {
		flex: 0 0 75%;
	}
	.edit_nav{
		text-align: center;
		background-color: #fff;
		padding: 0.3rem;
		margin: 0.1rem 1rem;
		border: 1px solid #eee;
		border-radius: 0.5rem;
	}
</style>
