<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','order_number') || $check_field('add','order_number') || $check_field('set','order_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订单号" prop="order_number">
												<el-input id="order_number" v-model="form['order_number']" placeholder="请输入订单号"
							  v-if="user_group === '管理员' || (form['after_sales_application_id'] && $check_field('set','order_number')) || (!form['after_sales_application_id'] && $check_field('add','order_number'))" :disabled="disabledObj['order_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','order_number')">{{form['order_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','trade_name') || $check_field('add','trade_name') || $check_field('set','trade_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品名称" prop="trade_name">
												<el-input id="trade_name" v-model="form['trade_name']" placeholder="请输入商品名称"
							  v-if="user_group === '管理员' || (form['after_sales_application_id'] && $check_field('set','trade_name')) || (!form['after_sales_application_id'] && $check_field('add','trade_name'))" :disabled="disabledObj['trade_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','trade_name')">{{form['trade_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','product_type') || $check_field('add','product_type') || $check_field('set','product_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品类型" prop="product_type">
												<el-input id="product_type" v-model="form['product_type']" placeholder="请输入商品类型"
							  v-if="user_group === '管理员' || (form['after_sales_application_id'] && $check_field('set','product_type')) || (!form['after_sales_application_id'] && $check_field('add','product_type'))" :disabled="disabledObj['product_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','product_type')">{{form['product_type']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','supplier_user') || $check_field('add','supplier_user') || $check_field('set','supplier_user')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="供货商用户" prop="supplier_user">
													<el-select v-if="user_group === '管理员' || (form['after_sales_application_id'] && $check_field('set','supplier_user')) || (!form['after_sales_application_id'] && $check_field('add','supplier_user'))" id="supplier_user" v-model="form['supplier_user']" :disabled="disabledObj['supplier_user_isDisabled']">
							<el-option v-for="o in list_user_supplier_user" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','supplier_user')" id="supplier_user" v-model="form['supplier_user']" :disabled="true">
							<el-option v-for="o in list_user_supplier_user" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','supplier_name') || $check_field('add','supplier_name') || $check_field('set','supplier_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="供货商名" prop="supplier_name">
												<el-input id="supplier_name" v-model="form['supplier_name']" placeholder="请输入供货商名"
							  v-if="user_group === '管理员' || (form['after_sales_application_id'] && $check_field('set','supplier_name')) || (!form['after_sales_application_id'] && $check_field('add','supplier_name'))" :disabled="disabledObj['supplier_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','supplier_name')">{{form['supplier_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','after_sales_quantity') || $check_field('add','after_sales_quantity') || $check_field('set','after_sales_quantity')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="售后数量" prop="after_sales_quantity">
								<el-input-number id="after_sales_quantity" v-model.number="form['after_sales_quantity']"
						v-if="user_group === '管理员' || (form['after_sales_application_id'] && $check_field('set','after_sales_quantity')) || (!form['after_sales_application_id'] && $check_field('add','after_sales_quantity'))" :disabled="disabledObj['after_sales_quantity_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','after_sales_quantity')">{{form['after_sales_quantity']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','user_name') || $check_field('add','user_name') || $check_field('set','user_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户名称" prop="user_name">
													<el-select v-if="user_group === '管理员' || (form['after_sales_application_id'] && $check_field('set','user_name')) || (!form['after_sales_application_id'] && $check_field('add','user_name'))" id="user_name" v-model="form['user_name']" :disabled="disabledObj['user_name_isDisabled']">
							<el-option v-for="o in list_user_user_name" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','user_name')" id="user_name" v-model="form['user_name']" :disabled="true">
							<el-option v-for="o in list_user_user_name" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','consignee') || $check_field('add','consignee') || $check_field('set','consignee')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="收货人" prop="consignee">
												<el-input id="consignee" v-model="form['consignee']" placeholder="请输入收货人"
							  v-if="user_group === '管理员' || (form['after_sales_application_id'] && $check_field('set','consignee')) || (!form['after_sales_application_id'] && $check_field('add','consignee'))" :disabled="disabledObj['consignee_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','consignee')">{{form['consignee']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','receiving_phone_number') || $check_field('add','receiving_phone_number') || $check_field('set','receiving_phone_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="收货电话" prop="receiving_phone_number">
												<el-input id="receiving_phone_number" v-model="form['receiving_phone_number']" placeholder="请输入收货电话"
							  v-if="user_group === '管理员' || (form['after_sales_application_id'] && $check_field('set','receiving_phone_number')) || (!form['after_sales_application_id'] && $check_field('add','receiving_phone_number'))" :disabled="disabledObj['receiving_phone_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','receiving_phone_number')">{{form['receiving_phone_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','shipping_address') || $check_field('add','shipping_address') || $check_field('set','shipping_address')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="收货地址" prop="shipping_address">
												<el-input id="shipping_address" v-model="form['shipping_address']" placeholder="请输入收货地址"
							  v-if="user_group === '管理员' || (form['after_sales_application_id'] && $check_field('set','shipping_address')) || (!form['after_sales_application_id'] && $check_field('add','shipping_address'))" :disabled="disabledObj['shipping_address_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','shipping_address')">{{form['shipping_address']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','after_sales_issues') || $check_field('add','after_sales_issues') || $check_field('set','after_sales_issues')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="售后问题" prop="after_sales_issues">
												<el-input id="after_sales_issues" v-model="form['after_sales_issues']" placeholder="请输入售后问题"
							  v-if="user_group === '管理员' || (form['after_sales_application_id'] && $check_field('set','after_sales_issues')) || (!form['after_sales_application_id'] && $check_field('add','after_sales_issues'))" :disabled="disabledObj['after_sales_issues_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','after_sales_issues')">{{form['after_sales_issues']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','problem_description') || $check_field('add','problem_description') || $check_field('set','problem_description')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="问题描述" prop="problem_description">
								<el-input type="textarea" id="problem_description" v-model="form['problem_description']" placeholder="请输入问题描述"
						v-if="user_group === '管理员' || (form['after_sales_application_id'] && $check_field('set','problem_description')) || (!form['after_sales_application_id'] && $check_field('add','problem_description'))" :disabled="disabledObj['problem_description_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','problem_description')">{{form['problem_description']}}</div>
							</el-form-item>
			</el-col>
					
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "after_sales_application_id",
				url_add: "~/api/after_sales_application/add?",
				url_set: "~/api/after_sales_application/set?",
				url_get_obj: "~/api/after_sales_application/get_obj?",
				url_upload: "~/api/after_sales_application/upload?",

				query: {
					"after_sales_application_id": 0,
				},

				form: {
								"order_number":  '', // 订单号
										"trade_name":  '', // 商品名称
										"product_type":  '', // 商品类型
										"supplier_user": 0, // 供货商用户
										"supplier_name":  '', // 供货商名
										"after_sales_quantity":  0, // 售后数量
										"user_name": 0, // 用户名称
										"consignee":  '', // 收货人
										"receiving_phone_number":  '', // 收货电话
										"shipping_address":  '', // 收货地址
										"after_sales_issues":  '', // 售后问题
										"problem_description":  '', // 问题描述
											"after_sales_application_id": 0, // ID
						
				},
				disabledObj:{
								"order_number_isDisabled": false,
										"trade_name_isDisabled": false,
										"product_type_isDisabled": false,
										"supplier_user_isDisabled": false,
										"supplier_name_isDisabled": false,
					          			"after_sales_quantity_isDisabled": false,
										"user_name_isDisabled": false,
										"consignee_isDisabled": false,
										"receiving_phone_number_isDisabled": false,
										"shipping_address_isDisabled": false,
										"after_sales_issues_isDisabled": false,
										"problem_description_isDisabled": false,
										},

	
		
		
		
					// 用户列表
				list_user_supplier_user: [],
				
		
		
					// 用户列表
				list_user_user_name: [],
				
		
		
		
		
	
			}
		},
		methods: {


	
	
			
	
			
	
			
	
				/**
			 * 获取供货商用户列表
			 */
			async get_list_user_supplier_user() {
                // if(this.user_group !== "管理员" && this.form["supplier_user"] === 0) {
                //     this.form["supplier_user"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=供货商");
                if(json.result && json.result.list){
                    this.list_user_supplier_user = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					get_user_supplier_user(id){
				var obj = this.list_user_supplier_user.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
	
			
	
				/**
			 * 获取普通用户用户列表
			 */
			async get_list_user_user_name() {
                // if(this.user_group !== "管理员" && this.form["user_name"] === 0) {
                //     this.form["user_name"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=普通用户");
                if(json.result && json.result.list){
                    this.list_user_user_name = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					get_user_user_name(id){
				var obj = this.list_user_user_name.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
	
			
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
																											// 获取缓存数据附加
				form = $.db.get("form");
							$.push(this.form ,form);
																						
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
																												$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


																																				


			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
				let msg = null
																																										return msg;
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/after_sales_application/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/after_sales_application/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/after_sales_application/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/after_sales_application/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/after_sales_application/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
											this.get_list_user_supplier_user();
												this.get_list_user_user_name();
															},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
