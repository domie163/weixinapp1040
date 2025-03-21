<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','commodity_map') || $check_field('add','commodity_map') || $check_field('set','commodity_map')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品图" prop="commodity_map">
								<el-upload :disabled="disabledObj['commodity_map_isDisabled']" id="commodity_map" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_commodity_map"
						:show-file-list="false" v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','commodity_map')) || (!form['product_information_id'] && $check_field('add','commodity_map'))">
						<img v-if="form['commodity_map']" :src="$fullUrl(form['commodity_map'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','commodity_map')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['commodity_map'])" :preview-src-list="[$fullUrl(form['commodity_map'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','trade_name') || $check_field('add','trade_name') || $check_field('set','trade_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品名称" prop="trade_name">
												<el-input id="trade_name" v-model="form['trade_name']" placeholder="请输入商品名称"
							  v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','trade_name')) || (!form['product_information_id'] && $check_field('add','trade_name'))" :disabled="disabledObj['trade_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','trade_name')">{{form['trade_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','product_type') || $check_field('add','product_type') || $check_field('set','product_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品类型" prop="product_type">
								<el-select id="product_type" v-model="form['product_type']"
						v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','product_type')) || (!form['product_information_id'] && $check_field('add','product_type'))">
						<el-option v-for="o in list_product_type" :key="o['product_type']" :label="o['product_type']"
							:value="o['product_type']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','product_type')">{{form['product_type']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','product_parameters') || $check_field('add','product_parameters') || $check_field('set','product_parameters')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品参数" prop="product_parameters">
												<el-input id="product_parameters" v-model="form['product_parameters']" placeholder="请输入商品参数"
							  v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','product_parameters')) || (!form['product_information_id'] && $check_field('add','product_parameters'))" :disabled="disabledObj['product_parameters_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','product_parameters')">{{form['product_parameters']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','specifications') || $check_field('add','specifications') || $check_field('set','specifications')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="规格" prop="specifications">
												<el-input id="specifications" v-model="form['specifications']" placeholder="请输入规格"
							  v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','specifications')) || (!form['product_information_id'] && $check_field('add','specifications'))" :disabled="disabledObj['specifications_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','specifications')">{{form['specifications']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','stock') || $check_field('add','stock') || $check_field('set','stock')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="库存" prop="stock">
								<el-select id="stock" v-model="form['stock']"
						v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','stock')) || (!form['product_information_id'] && $check_field('add','stock'))">
						<el-option v-for="o in list_stock" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','stock')">{{form['stock']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','price') || $check_field('add','price') || $check_field('set','price')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="价格" prop="price">
								<el-input-number id="price" v-model.number="form['price']"
						v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','price')) || (!form['product_information_id'] && $check_field('add','price'))" :disabled="disabledObj['price_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','price')">{{form['price']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','supplier_user') || $check_field('add','supplier_user') || $check_field('set','supplier_user')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="供货商用户" prop="supplier_user">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_supplier_user(form['supplier_user']) }}
							<!--<el-input id="business_name" v-model="form['supplier_user']" placeholder="请输入供货商用户"-->
							<!--v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','supplier_user')) || (!form['product_information_id'] && $check_field('add','supplier_user'))" :disabled="disabledObj['supplier_user_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','supplier_user')">{{form['supplier_user']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','supplier_user')) || (!form['product_information_id'] && $check_field('add','supplier_user'))" id="supplier_user" v-model="form['supplier_user']" :disabled="disabledObj['supplier_user_isDisabled']">
								<el-option v-for="o in list_user_supplier_user" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','supplier_user')" id="supplier_user" v-model="form['supplier_user']" :disabled="true">
								<el-option v-for="o in list_user_supplier_user" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="supplier_user" v-model="form['supplier_user']" :disabled="disabledObj['supplier_user_isDisabled']">
							<el-option v-for="o in list_user_supplier_user" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','supplier_name') || $check_field('add','supplier_name') || $check_field('set','supplier_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="供货商名" prop="supplier_name">
												<el-input id="supplier_name" v-model="form['supplier_name']" placeholder="请输入供货商名"
							  v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','supplier_name')) || (!form['product_information_id'] && $check_field('add','supplier_name'))" :disabled="disabledObj['supplier_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','supplier_name')">{{form['supplier_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','product_introduction') || $check_field('add','product_introduction') || $check_field('set','product_introduction')" :xs="24" :sm="24" :lg="24" class="el_form_editor_warp">
				<el-form-item label="商品介绍" prop="product_introduction">
					<quill-editor v-model.number="form['product_introduction']"
						v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','product_introduction')) || (!form['product_information_id'] && $check_field('add','product_introduction')) ">
					</quill-editor>
					<div v-else-if="$check_field('get','product_introduction')" v-html="form['product_introduction']"></div>
				</el-form-item>
			</el-col>
							<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="审核状态" prop="examine_state">
					<el-select id="examine_state" v-model="form['examine_state']"
						v-if="user_group === '管理员' || (form['examine_state'] && $check_examine()) || (!form['examine_state'] && $check_examine())">
						<el-option key="未审核" label="未审核" value="未审核"></el-option>
						<el-option key="已通过" label="已通过" value="已通过"></el-option>
						<el-option key="未通过" label="未通过" value="未通过"></el-option>
					</el-select>
					<div v-else>{{form["examine_state"]}}</div>
				</el-form-item>
			</el-col>
					<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="审核回复" prop="examine_reply">
					<el-input id="examine_reply" v-model="form['examine_reply']" placeholder="请输入审核回复"
						v-if="user_group === '管理员' || (form['examine_reply'] && $check_examine()) || (!form['examine_reply'] && $check_examine())"></el-input>
					<div v-else>{{form["examine_reply"]}}</div>
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
				field: "product_information_id",
				url_add: "~/api/product_information/add?",
				url_set: "~/api/product_information/set?",
				url_get_obj: "~/api/product_information/get_obj?",
				url_upload: "~/api/product_information/upload?",

				query: {
					"product_information_id": 0,
				},

				form: {
								"commodity_map":  '', // 商品图
										"trade_name":  '', // 商品名称
										"product_type":  '', // 商品类型
										"product_parameters":  '', // 商品参数
										"specifications":  '', // 规格
										"stock":  '', // 库存
										"price":  0, // 价格
										"supplier_user": 0, // 供货商用户
										"supplier_name":  '', // 供货商名
										"product_introduction":  '', // 商品介绍
									"examine_state": "未审核",
							"examine_reply": "",
							"product_information_id": 0, // ID
						
				},
				disabledObj:{
								"commodity_map_isDisabled": false,
										"trade_name_isDisabled": false,
										"product_type_isDisabled": false,
										"product_parameters_isDisabled": false,
										"specifications_isDisabled": false,
										"stock_isDisabled": false,
					          			"price_isDisabled": false,
										"supplier_user_isDisabled": false,
										"supplier_name_isDisabled": false,
										"product_introduction_isDisabled": false,
										},

	
		
						// 商品类型选项列表
				list_product_type: [""],
	
		
		
						// 库存选项列表
				list_stock: ['1','不限'],
	
		
		
					// 用户列表
				list_user_supplier_user: [],
						// 用户组
				group_user_supplier_user: "",
				
		
	
			}
		},
		methods: {


				/**
			 * 上传商品图
			 * @param {Object} param 图片参数
			 */
			upload_commodity_map(param){
						this.uploadFile(param.file, "commodity_map");
					},
	
	
			
	
			
				/**
			 * 获取商品类型列表
			 */
			async get_list_product_type() {
				var json = await this.$get("~/api/product_type/get_list?");
				if(json.result && json.result.list){
					this.list_product_type = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
			
	
			
	
			
	
			
	
			
	
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
					/**
			 * 获取供货商用户组
			 */
			async get_group_user_supplier_user() {
							this.form["supplier_user"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=供货商");
				if(json.result && json.result.obj){
					this.group_user_supplier_user = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_supplier_user(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_supplier_user.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
									for (let key in _this.form) {
							arrForm.push(key)
						}
												_this.form["supplier_user"] = id
									_this.disabledObj['supplier_user' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "supplier_user") {
			                      _this.form[arrForm[j]] = res.result.obj[arr[i]]
			                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								  break;
								} else {
								  _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								}
							  }
							}
						  }
						}
					}
				});
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
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
																																								
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
					bl = this.$check_action('/product_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/product_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/product_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/product_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/product_information/view','get');
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
								this.get_list_product_type();
															this.get_list_user_supplier_user();
					this.get_group_user_supplier_user();
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
