<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','supplier_user') || $check_field('add','supplier_user') || $check_field('set','supplier_user')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="供货商用户" prop="supplier_user">
													<el-select v-if="user_group === '管理员' || (form['consultation_records_id'] && $check_field('set','supplier_user')) || (!form['consultation_records_id'] && $check_field('add','supplier_user'))" id="supplier_user" v-model="form['supplier_user']" :disabled="disabledObj['supplier_user_isDisabled']">
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
							  v-if="user_group === '管理员' || (form['consultation_records_id'] && $check_field('set','supplier_name')) || (!form['consultation_records_id'] && $check_field('add','supplier_name'))" :disabled="disabledObj['supplier_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','supplier_name')">{{form['supplier_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','user_name') || $check_field('add','user_name') || $check_field('set','user_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户名称" prop="user_name">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_user_name(form['user_name']) }}
							<!--<el-input id="business_name" v-model="form['user_name']" placeholder="请输入用户名称"-->
							<!--v-if="user_group === '管理员' || (form['consultation_records_id'] && $check_field('set','user_name')) || (!form['consultation_records_id'] && $check_field('add','user_name'))" :disabled="disabledObj['user_name_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','user_name')">{{form['user_name']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['consultation_records_id'] && $check_field('set','user_name')) || (!form['consultation_records_id'] && $check_field('add','user_name'))" id="user_name" v-model="form['user_name']" :disabled="disabledObj['user_name_isDisabled']">
								<el-option v-for="o in list_user_user_name" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','user_name')" id="user_name" v-model="form['user_name']" :disabled="true">
								<el-option v-for="o in list_user_user_name" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="user_name" v-model="form['user_name']" :disabled="disabledObj['user_name_isDisabled']">
							<el-option v-for="o in list_user_user_name" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','consultation_topic') || $check_field('add','consultation_topic') || $check_field('set','consultation_topic')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="咨询主题" prop="consultation_topic">
												<el-input id="consultation_topic" v-model="form['consultation_topic']" placeholder="请输入咨询主题"
							  v-if="user_group === '管理员' || (form['consultation_records_id'] && $check_field('set','consultation_topic')) || (!form['consultation_records_id'] && $check_field('add','consultation_topic'))" :disabled="disabledObj['consultation_topic_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','consultation_topic')">{{form['consultation_topic']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','consultation_content') || $check_field('add','consultation_content') || $check_field('set','consultation_content')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="咨询内容" prop="consultation_content">
								<el-input type="textarea" id="consultation_content" v-model="form['consultation_content']" placeholder="请输入咨询内容"
						v-if="user_group === '管理员' || (form['consultation_records_id'] && $check_field('set','consultation_content')) || (!form['consultation_records_id'] && $check_field('add','consultation_content'))" :disabled="disabledObj['consultation_content_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','consultation_content')">{{form['consultation_content']}}</div>
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
				field: "consultation_records_id",
				url_add: "~/api/consultation_records/add?",
				url_set: "~/api/consultation_records/set?",
				url_get_obj: "~/api/consultation_records/get_obj?",
				url_upload: "~/api/consultation_records/upload?",

				query: {
					"consultation_records_id": 0,
				},

				form: {
								"supplier_user": 0, // 供货商用户
										"supplier_name":  '', // 供货商名
										"user_name": 0, // 用户名称
										"consultation_topic":  '', // 咨询主题
										"consultation_content":  '', // 咨询内容
											"consultation_records_id": 0, // ID
						
				},
				disabledObj:{
								"supplier_user_isDisabled": false,
										"supplier_name_isDisabled": false,
										"user_name_isDisabled": false,
										"consultation_topic_isDisabled": false,
										"consultation_content_isDisabled": false,
										},

	
					// 用户列表
				list_user_supplier_user: [],
				
		
					// 用户列表
				list_user_user_name: [],
						// 用户组
				group_user_user_name: "",
				
		
	
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
					/**
			 * 获取普通用户用户组
			 */
			async get_group_user_user_name() {
							this.form["user_name"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=普通用户");
				if(json.result && json.result.obj){
					this.group_user_user_name = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_user_name(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_user_name.source_table+"/get_obj?"
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
												_this.form["user_name"] = id
									_this.disabledObj['user_name' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "user_name") {
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
					bl = this.$check_action('/consultation_records/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/consultation_records/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/consultation_records/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/consultation_records/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/consultation_records/view','get');
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
					this.get_group_user_user_name();
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
