<template>
	<view class="diy_edit page_live_booking" id="live_booking_edit">
		<view class='warp'>
			<view class='container'>
				<view class='row'>
						<view v-if="$check_field('set','trade_name') || $check_field('add','trade_name') || $check_field('get','trade_name')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								商品名称:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_trade_name" v-model="form['trade_name']" placeholder="请输入商品名称" v-if="(form['trade_name'] && $check_field('set','trade_name')) || (!form['trade_name'] && $check_field('add','trade_name'))" :disabled="disabledObj['trade_name_isDisabled']" />
							<text v-else-if="$check_field('get','trade_name')">{{ form['trade_name'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','product_type') || $check_field('add','product_type') || $check_field('get','product_type')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								商品类型:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_product_type" v-model="form['product_type']" placeholder="请输入商品类型" v-if="(form['product_type'] && $check_field('set','product_type')) || (!form['product_type'] && $check_field('add','product_type'))" :disabled="disabledObj['product_type_isDisabled']" />
							<text v-else-if="$check_field('get','product_type')">{{ form['product_type'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','product_parameters') || $check_field('add','product_parameters') || $check_field('get','product_parameters')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								商品参数:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_product_parameters" v-model="form['product_parameters']" placeholder="请输入商品参数" v-if="(form['product_parameters'] && $check_field('set','product_parameters')) || (!form['product_parameters'] && $check_field('add','product_parameters'))" :disabled="disabledObj['product_parameters_isDisabled']" />
							<text v-else-if="$check_field('get','product_parameters')">{{ form['product_parameters'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','specifications') || $check_field('add','specifications') || $check_field('get','specifications')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								规格:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_specifications" v-model="form['specifications']" placeholder="请输入规格" v-if="(form['specifications'] && $check_field('set','specifications')) || (!form['specifications'] && $check_field('add','specifications'))" :disabled="disabledObj['specifications_isDisabled']" />
							<text v-else-if="$check_field('get','specifications')">{{ form['specifications'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','price') || $check_field('add','price') || $check_field('get','price')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								价格:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_price" v-model="form['price']" placeholder="请输入价格" v-if="(form['price'] && $check_field('set','price')) || (!form['price'] && $check_field('add','price'))" :disabled="disabledObj['price_isDisabled']" />
							<text v-else-if="$check_field('get','price')">{{ form['price'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','supplier_user') || $check_field('add','supplier_user') || $check_field('get','supplier_user')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								供货商用户:
							</text>
						</view>
						<view class="diy_field diy_down diy_text_row diy_select_flex">
							<uni-data-select
									id="form_supplier_user"
									v-model="form['supplier_user']"
									:localdata="list_user_supplier_user"
									:clear="!disabledObj['supplier_user_isDisabled']"
									:disabled="disabledObj['supplier_user_isDisabled']"
									v-if="(form['supplier_user'] && $check_field('set','supplier_user')) || (!form['supplier_user'] && $check_field('add','supplier_user'))"
							></uni-data-select>
							<text v-else-if="$check_field('get','supplier_user')">{{ form['supplier_user'] }}</text>
						</view>
					</view>
							<view v-if="$check_field('set','supplier_name') || $check_field('add','supplier_name') || $check_field('get','supplier_name')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								供货商名:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_supplier_name" v-model="form['supplier_name']" placeholder="请输入供货商名" v-if="(form['supplier_name'] && $check_field('set','supplier_name')) || (!form['supplier_name'] && $check_field('add','supplier_name'))" :disabled="disabledObj['supplier_name_isDisabled']" />
							<text v-else-if="$check_field('get','supplier_name')">{{ form['supplier_name'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','user_name') || $check_field('add','user_name') || $check_field('get','user_name')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								用户名称:
							</text>
						</view>
						<view class="diy_field diy_down diy_text_row diy_select_flex">
							<uni-data-select
									id="form_user_name"
									v-model="form['user_name']"
									:localdata="list_user_user_name"
									:clear="!disabledObj['user_name_isDisabled']"
									:disabled="disabledObj['user_name_isDisabled']"
									v-if="(form['user_name'] && $check_field('set','user_name')) || (!form['user_name'] && $check_field('add','user_name'))"
							></uni-data-select>
							<text v-else-if="$check_field('get','user_name')">{{ form['user_name'] }}</text>
						</view>
					</view>
							<view v-if="$check_field('set','time_of_appointment') || $check_field('add','time_of_appointment') || $check_field('get','time_of_appointment')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								预约时间:
							</text>
						</view>
								<!-- 日长 -->
						<view class="diy_field diy_datetime diy_text_row">
							<uni-datetime-picker :disabled="disabledObj['time_of_appointment_isDisabled']" type="datetime" id="form_time_of_appointment" v-model="form['time_of_appointment']" placeholder="请输入预约时间" v-if="(form['time_of_appointment'] && $check_field('set','time_of_appointment')) || (!form['time_of_appointment'] && $check_field('add','time_of_appointment'))" />
							<text v-else-if="$check_field('get','time_of_appointment')">{{ form['time_of_appointment'] }}</text>
						</view>
							</view>
							<view v-if="$check_field('set','live_streaming_plan') || $check_field('add','live_streaming_plan') || $check_field('get','live_streaming_plan')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								直播计划:
							</text>
						</view>
								<!-- 多文本 -->
						<view class="diy_field diy_desc diy_text_row">
							<textarea id="form_live_streaming_plan" v-model="form['live_streaming_plan']" v-if="(form['live_streaming_plan'] && $check_field('set','live_streaming_plan')) || (!form['live_streaming_plan'] && $check_field('add','live_streaming_plan'))" :disabled="disabledObj['live_streaming_plan_isDisabled']"/>
							<text v-else-if="$check_field('get','live_streaming_plan')">{{ form['live_streaming_plan'] }}</text>
						</view>
							</view>
							<view v-if="$check_field('set','live_remarks') || $check_field('add','live_remarks') || $check_field('get','live_remarks')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								直播备注:
							</text>
						</view>
								<!-- 多文本 -->
						<view class="diy_field diy_desc diy_text_row">
							<textarea id="form_live_remarks" v-model="form['live_remarks']" v-if="(form['live_remarks'] && $check_field('set','live_remarks')) || (!form['live_remarks'] && $check_field('add','live_remarks'))" :disabled="disabledObj['live_remarks_isDisabled']"/>
							<text v-else-if="$check_field('get','live_remarks')">{{ form['live_remarks'] }}</text>
						</view>
							</view>
						<view v-if="user_group === '管理员' || $check_examine()" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								审核状态:
							</text>
						</view>
						<view class="diy_field diy_text diy_text_row diy_select_flex">
							<uni-data-select
									v-model="form['examine_state']"
									:localdata="list_examine_state"
							></uni-data-select>
						</view>
						<view class="diy_field diy_text diy_text_row">
							<text>
								{{ form['examine_state'] }}
							</text>
						</view>
					</view>
					<view v-if="user_group === '管理员' || $check_examine()" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								审核回复:
							</text>
						</view>
						<view class="diy_field diy_text diy_text_row">
							<textarea v-model="form['examine_reply']">
							</textarea>
						</view>
						<view class="diy_field diy_text diy_text_row">
							<text>
								{{ form['examine_reply'] }}
							</text>
						</view>
					</view>

				</view>
				<view class="row">
					<view class="col-12">
						<view class="btn_box">
							<button class="btn_submit primary_btn" @click="submit()">提交</button>
						</view>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
import mixin from "@/libs/mixins/page.js";
export default {
	mixins:[mixin],
	components:{},
	data(){
		return{
			url_get_obj:"~/api/live_booking/get_obj?",
			url_add:"~/api/live_booking/add?",
			url_set:"~/api/live_booking/set?",

			// 登录权限
			oauth: {
				"signIn": true,
				"user_group": []
			},

			// 查询条件
			query: {
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
					"live_booking_id": 0
			},

			obj: {
					"trade_name":  '', // 商品名称
						"product_type":  '', // 商品类型
						"product_parameters":  '', // 商品参数
						"specifications":  '', // 规格
						"price":  '', // 价格
						"supplier_user": 0, // 供货商用户
						"supplier_name":  '', // 供货商名
						"user_name": 0, // 用户名称
						"time_of_appointment": this.$toTime(new Date().getTime(), "yyyy-MM-dd hh:mm:ss"),
						"live_streaming_plan":  '', // 直播计划
						"live_remarks":  '', // 直播备注
					"examine_state": "未审核",
				"examine_reply": "",
				"live_booking_id": 0,

			},

			// 表单字段
			form: {
					"trade_name":  '', // 商品名称
						"product_type":  '', // 商品类型
						"product_parameters":  '', // 商品参数
						"specifications":  '', // 规格
						"price":  '', // 价格
						"supplier_user": 0, // 供货商用户
						"supplier_name":  '', // 供货商名
						"user_name": 0, // 用户名称
						"time_of_appointment": this.$toTime(new Date().getTime(), "yyyy-MM-dd hh:mm:ss"),
						"live_streaming_plan":  '', // 直播计划
						"live_remarks":  '', // 直播备注
					"examine_state": "未审核",
				"examine_reply": "",
				"live_booking_id": 0,
			},
			disabledObj:{
					"trade_name_isDisabled": false,
						"product_type_isDisabled": false,
						"product_parameters_isDisabled": false,
						"specifications_isDisabled": false,
						"price_isDisabled": false,
						"supplier_user_isDisabled": false,
						"supplier_name_isDisabled": false,
						"user_name_isDisabled": false,
						"time_of_appointment_isDisabled": false,
						"live_streaming_plan_isDisabled": false,
						"live_remarks_isDisabled": false,
				},

															// 用户列表
			list_user_supplier_user: [],
								// 用户列表
			list_user_user_name: [],
							
			field:"live_booking_id",
			table_key:"live_booking",

	list_examine_state:[{value:"未审核",text:"未审核"},{value:"已通过",text:"已通过"},{value:"未通过",text:"未通过"}],
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
				json.result.list.map((o) => this.list_user_supplier_user.push({value:o.user_id,text:o.nickname + '-' + o.username}));
			}
			else if(json.error){
				console.error(json.error);
			}
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
				json.result.list.map((o) => this.list_user_user_name.push({value:o.user_id,text:o.nickname + '-' + o.username}));
			}
			else if(json.error){
				console.error(json.error);
			}
		},
				async get_user_session_user_name(){
			var _this = this;
			var json = await this.$get("~/api/user_group/get_obj?name=普通用户");
			if(json.result && json.result.obj){
				var source_table = json.result.obj.source_table;
				var user_id = _this.$store.state.user.user_id;
				if (user_id){
					var url = "~/api/"+source_table+"/get_obj?"
					this.$get(url, {"user_id":_this.$store.state.user.user_id}, function(res) {
						if (res.result && res.result.obj) {
							var arr = []
							for (let key in res.result.obj) {
								arr.push(key)
							}
							var arrForm = []
							for (let key in _this.form) {
								arrForm.push(key)
							}
							_this.form["user_name"] = user_id
							_this.disabledObj['user_name' + '_isDisabled'] = true
							for (var i=0;i<arr.length;i++){
                if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
                  for (var j = 0; j < arrForm.length; j++) {
                    if (arr[i] === arrForm[j]) {
                      if (arr[i] !== "user_name") {
                        _this.form[arrForm[j]] = res.result.obj[arr[i]]
                        _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                        break;
                      }
                    }
                  }
                }
							}
						}
					});
				}
			}
			else if(json.error){
				console.error(json.error);
			}
		},
	
	
				
	
				
	
				
	
			change_file(key_name){
			var _self = this;
				this.$chooseFile().then(res=>{
					console.log(res)

						const uploadTask = uni.uploadFile({
							url: _self.$fullUrl("/api/feedback/upload?"),
							filePath: res[0].path,
							name: "file",
							formData: {
								i_want_to_customize: "test",
							},
							header: {
								"x-auth-token": _self.$store.state.user.token,
							},
							success: function(uploadFileRes) {
								console.log(uploadFileRes)
								var filename = JSON.parse(uploadFileRes.data).result.url;
								_self.form[key_name] = filename;
							},
						});

						uploadTask.onProgressUpdate(function(res) {
							_self.percent = res.progress;
							console.log("上传进度" + res.progress);
							console.log("已经上传的数据长度" + res.totalBytesSent);
							console.log(
								"预期需要上传的数据总长度" + res.totalBytesExpectedToSend
							);
						});

				})
		},
		change_img(key_name) {
			var _self = this;
			_self.upload_img_flag = false
			// 选择图像方法
			uni.chooseImage({
				count: 1,
				sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
				sourceType: ['album'], //从相册选择
				success: function(res) {
					const tempFilePaths = res.tempFilePaths;
					const uploadTask = uni.uploadFile({
						url: _self.$fullUrl('/api/live_booking/upload?'),
						filePath: tempFilePaths[0],
						name: 'file',
						formData: {
							'live_booking': 'test'
						},
						header: {
							'x-auth-token': _self.$store.state.user.token
						},
						success: function(uploadFileRes) {
							var filename = JSON.parse(uploadFileRes.data).result.url
							var img_url = filename
							_self.form[key_name] = img_url
						}
					});

					uploadTask.onProgressUpdate(function(res) {
						_self.percent = res.progress;
						console.log('上传进度' + res.progress);
						console.log('已经上传的数据长度' + res.totalBytesSent);
						console.log('预期需要上传的数据总长度' + res.totalBytesExpectedToSend);
					});
				},
				error: function(e) {
					console.log(e);
				}
			});
		},

		/**
		 * 获取对象后获取缓存表单
		 * @param {Object} json
		 * @param {Object} func
		 */
		get_obj_before(param){
			var form = uni.db.get("form");
			if (form) {
        delete(form.examine_state)
        delete(form.examine_reply)
				this.obj = uni.push(this.obj ,form);
				this.form = uni.push(this.form ,form);
			}
			var arr = []
			for (let key in form) {
				arr.push(key)
			}
			for (var i=0;i<arr.length;i++){
				this.disabledObj[arr[i] + '_isDisabled'] = true
			}
																				if (this.form["time_of_appointment"] && JSON.stringify(this.form["time_of_appointment"]).indexOf("-")===-1) {
				this.form["time_of_appointment"] = this.$toTime(parseInt(this.form["time_of_appointment"]), "yyyy-MM-dd hh:mm:ss")
			}
									uni.db.del("form");
			return param;
		},

		/**
		 * 获取对象后获取缓存表单
		 * @param {Object} json
		 * @param {Object} func
		 */
		get_obj_after(json ,func){
			var form = uni.db.get("form");
			var obj = Object.assign({} ,form ,this.obj);
			if (form) {
				this.obj = uni.push(this.obj ,obj);
			}
			if (form) {
				this.form = uni.push(this.form ,form);
			}
			if(func){
				func(json);
			}
		},

	},
	onLoad(){
																				this.get_list_user_supplier_user();
								this.get_user_session_user_name();
				this.get_list_user_user_name();
											},
}
</script>

<style scoped>
	input{
		font-size: 10px;
	}

	.form_edit {
		background-color: #fff;
		margin-bottom: 0.5rem;
		padding: 1rem;
		font-size: 10px;
	}

	.item {
		display: flex;
		padding: 0.2rem 0;
	}

	.left_text {
		flex: 0 0 25%;
		display: flex;
		align-items: center;
	}

	.right_text {
		flex: 0 0 75%;
		border-bottom: 1px solid #eee;
	}
	.right_text.btn_warp{
		border-bottom: 0;
	}

	.btn_submit {
		text-align: center;
		background-color: #fff;
		padding: 0.3rem;
		margin: 0.1rem 1rem;
		border: 1px solid #eee;
		border-radius: 0.5rem;
	}

	.btn_submit:hover {
		opacity: 0.5;
	}
	.btn_add_img{
		color: #D3D3D3;
		text-align: center;
		border: 1px solid #eee;
		height: 5rem;
		width: 5rem;
		position: relative;
	}
	.btn_add_img text{
		font-size: 35px;
		position: absolute;
		left: 50%;
		top: 50%;
		transform: translate(-50%,-50%);
	}




</style>
<style scoped>
/*新样式*/
.diy_text_row {
  display: inline-block;
}
.container {
	margin-top:1rem ;
	padding: 1rem;
    -webkit-box-shadow: 0px 0px 0px #888888;
    box-shadow: 0px 0px 0px #888888;
}
.primary_btn{
		background-color: #22B8B8;
		color: #FFFFFF;
	}
	.btn_submit{
		padding: 0;
		margin-top:1rem ;
	}
	.row-item {
		padding: 10px 10px;
	    background: #f8f6fc;
		margin-bottom: 1rem;
	}
	.diy_field{
		padding-left: 1rem;
	}
	.diy_title{
		align-items: center;
        font-size: 14px;
        color: #333;
	}

	.row-item{
		display: flex !important;
		align-items: baseline;
	}
	.diy_select_flex{
		flex: 1;
	}
	.query_select{
		flex: 1;
		border-color: rgb(229, 229, 229);
		background-color: rgb(255, 255, 255);
		border-radius: 4px;
		box-sizing: border-box;
		flex: 1;
		width: 100%;
		line-height: 2;
		font-size: 14px;
		height: 2.4em;
		min-height: 2.4em;
		display: block;
		outline:none;
	}
</style>

