<template>
	<view class="diy_edit page_appointment_order" id="appointment_order_edit">
		<view class='warp'>
			<view class='container'>
				<view class='row'>
						<view v-if="$check_field('set','order_number') || $check_field('add','order_number') || $check_field('get','order_number')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								订单号:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_order_number" v-model="form['order_number']" placeholder="请输入订单号" v-if="(form['order_number'] && $check_field('set','order_number')) || (!form['order_number'] && $check_field('add','order_number'))" :disabled="true" />
							<text v-else-if="$check_field('get','order_number')">{{ form['order_number'] }}</text>
						</view>
										</view>
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
							<view v-if="$check_field('set','order_quantity') || $check_field('add','order_quantity') || $check_field('get','order_quantity')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								订购数量:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_order_quantity" v-model="form['order_quantity']" placeholder="请输入订购数量" v-if="(form['order_quantity'] && $check_field('set','order_quantity')) || (!form['order_quantity'] && $check_field('add','order_quantity'))" :disabled="disabledObj['order_quantity_isDisabled']" />
							<text v-else-if="$check_field('get','order_quantity')">{{ form['order_quantity'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','order_amount') || $check_field('add','order_amount') || $check_field('get','order_amount')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								订购金额:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_order_amount" v-model="form['order_amount']" placeholder="请输入订购金额" v-if="(form['order_amount'] && $check_field('set','order_amount')) || (!form['order_amount'] && $check_field('add','order_amount'))" @focus="set_order_amount()" :disabled="disabledObj['order_amount_isDisabled']" />
							<text v-else-if="$check_field('get','order_amount')">{{ form['order_amount'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','whether_to_identify') || $check_field('add','whether_to_identify') || $check_field('get','whether_to_identify')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								是否鉴定:
							</text>
						</view>
								<!-- 选项 -->
						<view class="diy_field diy_down diy_text_row diy_select_flex">
							<uni-data-select
									id="form_whether_to_identify"
									v-model="form['whether_to_identify']"
									:localdata="list_whether_to_identify"
									v-if="(form['whether_to_identify'] && $check_field('set','whether_to_identify')) || (!form['whether_to_identify'] && $check_field('add','whether_to_identify'))"
							></uni-data-select>
							<text v-else-if="$check_field('get','whether_to_identify')">{{ form['whether_to_identify'] }}</text>
						</view>
							</view>
							<view v-if="$check_field('set','appraisal_fees') || $check_field('add','appraisal_fees') || $check_field('get','appraisal_fees')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								鉴定费用:
							</text>
						</view>
								<!-- 选项 -->
						<view class="diy_field diy_down diy_text_row diy_select_flex">
							<uni-data-select
									id="form_appraisal_fees"
									v-model="form['appraisal_fees']"
									:localdata="list_appraisal_fees"
									v-if="(form['appraisal_fees'] && $check_field('set','appraisal_fees')) || (!form['appraisal_fees'] && $check_field('add','appraisal_fees'))"
							></uni-data-select>
							<text v-else-if="$check_field('get','appraisal_fees')">{{ form['appraisal_fees'] }}</text>
						</view>
							</view>
							<view v-if="$check_field('set','total_amount') || $check_field('add','total_amount') || $check_field('get','total_amount')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								总金额:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_total_amount" v-model="form['total_amount']" placeholder="请输入总金额" v-if="(form['total_amount'] && $check_field('set','total_amount')) || (!form['total_amount'] && $check_field('add','total_amount'))" @focus="set_total_amount()" :disabled="disabledObj['total_amount_isDisabled']" />
							<text v-else-if="$check_field('get','total_amount')">{{ form['total_amount'] }}</text>
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
							<view v-if="$check_field('set','pickup_method') || $check_field('add','pickup_method') || $check_field('get','pickup_method')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								取货方式:
							</text>
						</view>
								<!-- 选项 -->
						<view class="diy_field diy_down diy_text_row diy_select_flex">
							<uni-data-select
									id="form_pickup_method"
									v-model="form['pickup_method']"
									:localdata="list_pickup_method"
									v-if="(form['pickup_method'] && $check_field('set','pickup_method')) || (!form['pickup_method'] && $check_field('add','pickup_method'))"
							></uni-data-select>
							<text v-else-if="$check_field('get','pickup_method')">{{ form['pickup_method'] }}</text>
						</view>
							</view>
							<view v-if="$check_field('set','consignee') || $check_field('add','consignee') || $check_field('get','consignee')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								收货人:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_consignee" v-model="form['consignee']" placeholder="请输入收货人" v-if="(form['consignee'] && $check_field('set','consignee')) || (!form['consignee'] && $check_field('add','consignee'))" :disabled="disabledObj['consignee_isDisabled']" />
							<text v-else-if="$check_field('get','consignee')">{{ form['consignee'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','receiving_phone_number') || $check_field('add','receiving_phone_number') || $check_field('get','receiving_phone_number')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								收货电话:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_receiving_phone_number" v-model="form['receiving_phone_number']" placeholder="请输入收货电话" v-if="(form['receiving_phone_number'] && $check_field('set','receiving_phone_number')) || (!form['receiving_phone_number'] && $check_field('add','receiving_phone_number'))" :disabled="disabledObj['receiving_phone_number_isDisabled']" />
							<text v-else-if="$check_field('get','receiving_phone_number')">{{ form['receiving_phone_number'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','shipping_address') || $check_field('add','shipping_address') || $check_field('get','shipping_address')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								收货地址:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_shipping_address" v-model="form['shipping_address']" placeholder="请输入收货地址" v-if="(form['shipping_address'] && $check_field('set','shipping_address')) || (!form['shipping_address'] && $check_field('add','shipping_address'))" :disabled="disabledObj['shipping_address_isDisabled']" />
							<text v-else-if="$check_field('get','shipping_address')">{{ form['shipping_address'] }}</text>
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
			url_get_obj:"~/api/appointment_order/get_obj?",
			url_add:"~/api/appointment_order/add?",
			url_set:"~/api/appointment_order/set?",

			// 登录权限
			oauth: {
				"signIn": true,
				"user_group": []
			},

			// 查询条件
			query: {
					"order_number": "",
						"trade_name": "",
						"product_type": "",
						"product_parameters": "",
						"specifications": "",
						"supplier_user": 0,
						"supplier_name": "",
						"price": "",
						"order_quantity": 0,
						"order_amount": "",
						"whether_to_identify": "",
						"appraisal_fees": "",
						"total_amount": "",
						"user_name": 0,
						"pickup_method": "",
						"consignee": "",
						"receiving_phone_number": "",
						"shipping_address": "",
					"appointment_order_id": 0
			},

			obj: {
					"order_number": this.$get_stamp(), // 订单号
						"trade_name":  '', // 商品名称
						"product_type":  '', // 商品类型
						"product_parameters":  '', // 商品参数
						"specifications":  '', // 规格
						"supplier_user": 0, // 供货商用户
						"supplier_name":  '', // 供货商名
						"price":  '', // 价格
						"order_quantity":  0 , // 订购数量
						"order_amount":  '', // 订购金额
						"whether_to_identify":  '', // 是否鉴定
						"appraisal_fees":  '', // 鉴定费用
						"total_amount":  '', // 总金额
						"user_name": 0, // 用户名称
						"pickup_method":  '', // 取货方式
						"consignee":  '', // 收货人
						"receiving_phone_number":  '', // 收货电话
						"shipping_address":  '', // 收货地址
					"examine_state": "未审核",
				"examine_reply": "",
				"appointment_order_id": 0,

			},

			// 表单字段
			form: {
					"order_number": this.$get_stamp(), // 订单号
						"trade_name":  '', // 商品名称
						"product_type":  '', // 商品类型
						"product_parameters":  '', // 商品参数
						"specifications":  '', // 规格
						"supplier_user": 0, // 供货商用户
						"supplier_name":  '', // 供货商名
						"price":  '', // 价格
						"order_quantity":  0 , // 订购数量
						"order_amount":  '', // 订购金额
						"whether_to_identify":  '', // 是否鉴定
						"appraisal_fees":  '', // 鉴定费用
						"total_amount":  '', // 总金额
						"user_name": 0, // 用户名称
						"pickup_method":  '', // 取货方式
						"consignee":  '', // 收货人
						"receiving_phone_number":  '', // 收货电话
						"shipping_address":  '', // 收货地址
					"examine_state": "未审核",
				"examine_reply": "",
				"appointment_order_id": 0,
			},
			disabledObj:{
					"order_number_isDisabled": false,
						"trade_name_isDisabled": false,
						"product_type_isDisabled": false,
						"product_parameters_isDisabled": false,
						"specifications_isDisabled": false,
						"supplier_user_isDisabled": false,
						"supplier_name_isDisabled": false,
						"price_isDisabled": false,
								"order_amount_isDisabled": false,
						"whether_to_identify_isDisabled": false,
						"appraisal_fees_isDisabled": false,
						"total_amount_isDisabled": false,
						"user_name_isDisabled": false,
						"pickup_method_isDisabled": false,
						"consignee_isDisabled": false,
						"receiving_phone_number_isDisabled": false,
						"shipping_address_isDisabled": false,
				},

															// 用户列表
			list_user_supplier_user: [],
													list_whether_to_identify: [],
						list_appraisal_fees: [],
									// 用户列表
			list_user_user_name: [],
					list_pickup_method: [],
								
			field:"appointment_order_id",
			table_key:"appointment_order",

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
		
	
				
	
				
	
				
	
				
	
								set_order_amount(){
			this.form.order_amount = parseFloat(this.form.price) * parseFloat(this.form.order_quantity)
			  let r = /^\+?[1-9][0-9]*$/; // 正整数
			  if(!r.test(this.form.order_amount) ){
				this.form.order_amount = this.form.order_amount.toFixed(2);
			  }
		},
														/**
		 * 获取是否鉴定列表
		 */
		async get_list_whether_to_identify() {
					['是','否'].map((o) => this.list_whether_to_identify.push({value:o,text:o}));
						},
			
	
				/**
		 * 获取鉴定费用列表
		 */
		async get_list_appraisal_fees() {
					['0','200'].map((o) => this.list_appraisal_fees.push({value:o,text:o}));
						},
			
	
				
	
													set_total_amount(){
			this.form.total_amount = parseFloat(this.form.order_amount) + parseFloat(this.form.appraisal_fees)
			  let r = /^\+?[1-9][0-9]*$/; // 正整数
			  if(!r.test(this.form.total_amount) ){
				this.form.total_amount = this.form.total_amount.toFixed(2);
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
	
	
				/**
		 * 获取取货方式列表
		 */
		async get_list_pickup_method() {
					['线下取货','线上发货'].map((o) => this.list_pickup_method.push({value:o,text:o}));
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
						url: _self.$fullUrl('/api/appointment_order/upload?'),
						filePath: tempFilePaths[0],
						name: 'file',
						formData: {
							'appointment_order': 'test'
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
																this.get_list_whether_to_identify();
						this.get_list_appraisal_fees();
										this.get_user_session_user_name();
				this.get_list_user_user_name();
				this.get_list_pickup_method();
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

