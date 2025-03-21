<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','order_number') || $check_field('add','order_number') || $check_field('set','order_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订单号" prop="order_number">
												<el-input id="order_number" v-model="form['order_number']" placeholder="请输入订单号"
							  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','order_number')) || (!form['appointment_order_id'] && $check_field('add','order_number'))" :disabled="true"></el-input>
					<div v-else-if="$check_field('get','order_number')">{{form['order_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','trade_name') || $check_field('add','trade_name') || $check_field('set','trade_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品名称" prop="trade_name">
												<el-input id="trade_name" v-model="form['trade_name']" placeholder="请输入商品名称"
							  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','trade_name')) || (!form['appointment_order_id'] && $check_field('add','trade_name'))" :disabled="disabledObj['trade_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','trade_name')">{{form['trade_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','product_type') || $check_field('add','product_type') || $check_field('set','product_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品类型" prop="product_type">
												<el-input id="product_type" v-model="form['product_type']" placeholder="请输入商品类型"
							  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','product_type')) || (!form['appointment_order_id'] && $check_field('add','product_type'))" :disabled="disabledObj['product_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','product_type')">{{form['product_type']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','product_parameters') || $check_field('add','product_parameters') || $check_field('set','product_parameters')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品参数" prop="product_parameters">
												<el-input id="product_parameters" v-model="form['product_parameters']" placeholder="请输入商品参数"
							  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','product_parameters')) || (!form['appointment_order_id'] && $check_field('add','product_parameters'))" :disabled="disabledObj['product_parameters_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','product_parameters')">{{form['product_parameters']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','specifications') || $check_field('add','specifications') || $check_field('set','specifications')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="规格" prop="specifications">
												<el-input id="specifications" v-model="form['specifications']" placeholder="请输入规格"
							  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','specifications')) || (!form['appointment_order_id'] && $check_field('add','specifications'))" :disabled="disabledObj['specifications_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','specifications')">{{form['specifications']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','supplier_user') || $check_field('add','supplier_user') || $check_field('set','supplier_user')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="供货商用户" prop="supplier_user">
													<el-select v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','supplier_user')) || (!form['appointment_order_id'] && $check_field('add','supplier_user'))" id="supplier_user" v-model="form['supplier_user']" :disabled="disabledObj['supplier_user_isDisabled']">
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
							  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','supplier_name')) || (!form['appointment_order_id'] && $check_field('add','supplier_name'))" :disabled="disabledObj['supplier_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','supplier_name')">{{form['supplier_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','price') || $check_field('add','price') || $check_field('set','price')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="价格" prop="price">
												<el-input id="price" v-model="form['price']" placeholder="请输入价格"
							  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','price')) || (!form['appointment_order_id'] && $check_field('add','price'))" :disabled="disabledObj['price_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','price')">{{form['price']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','order_quantity') || $check_field('add','order_quantity') || $check_field('set','order_quantity')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订购数量" prop="order_quantity">
								<el-input-number id="order_quantity" v-model.number="form['order_quantity']"
						v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','order_quantity')) || (!form['appointment_order_id'] && $check_field('add','order_quantity'))" :disabled="disabledObj['order_quantity_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','order_quantity')">{{form['order_quantity']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','order_amount') || $check_field('add','order_amount') || $check_field('set','order_amount')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订购金额" prop="order_amount">
												<el-input id="order_amount" v-model="form['order_amount']" placeholder="请输入订购金额"
							  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','order_amount')) || (!form['appointment_order_id'] && $check_field('add','order_amount'))"  @focus="set_order_amount()" :disabled="disabledObj['order_amount_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','order_amount')">{{form['order_amount']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','whether_to_identify') || $check_field('add','whether_to_identify') || $check_field('set','whether_to_identify')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="是否鉴定" prop="whether_to_identify">
								<el-select id="whether_to_identify" v-model="form['whether_to_identify']"
						v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','whether_to_identify')) || (!form['appointment_order_id'] && $check_field('add','whether_to_identify'))">
						<el-option v-for="o in list_whether_to_identify" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','whether_to_identify')">{{form['whether_to_identify']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','appraisal_fees') || $check_field('add','appraisal_fees') || $check_field('set','appraisal_fees')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="鉴定费用" prop="appraisal_fees">
								<el-select id="appraisal_fees" v-model="form['appraisal_fees']"
						v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','appraisal_fees')) || (!form['appointment_order_id'] && $check_field('add','appraisal_fees'))">
						<el-option v-for="o in list_appraisal_fees" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','appraisal_fees')">{{form['appraisal_fees']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','total_amount') || $check_field('add','total_amount') || $check_field('set','total_amount')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="总金额" prop="total_amount">
												<el-input id="total_amount" v-model="form['total_amount']" placeholder="请输入总金额"
							  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','total_amount')) || (!form['appointment_order_id'] && $check_field('add','total_amount'))"  @focus="set_total_amount()" :disabled="disabledObj['total_amount_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','total_amount')">{{form['total_amount']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','user_name') || $check_field('add','user_name') || $check_field('set','user_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户名称" prop="user_name">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_user_name(form['user_name']) }}
							<!--<el-input id="business_name" v-model="form['user_name']" placeholder="请输入用户名称"-->
							<!--v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','user_name')) || (!form['appointment_order_id'] && $check_field('add','user_name'))" :disabled="disabledObj['user_name_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','user_name')">{{form['user_name']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','user_name')) || (!form['appointment_order_id'] && $check_field('add','user_name'))" id="user_name" v-model="form['user_name']" :disabled="disabledObj['user_name_isDisabled']">
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
								<el-col v-if="user_group === '管理员' || $check_field('get','pickup_method') || $check_field('add','pickup_method') || $check_field('set','pickup_method')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="取货方式" prop="pickup_method">
								<el-select id="pickup_method" v-model="form['pickup_method']"
						v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','pickup_method')) || (!form['appointment_order_id'] && $check_field('add','pickup_method'))">
						<el-option v-for="o in list_pickup_method" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','pickup_method')">{{form['pickup_method']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','consignee') || $check_field('add','consignee') || $check_field('set','consignee')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="收货人" prop="consignee">
												<el-input id="consignee" v-model="form['consignee']" placeholder="请输入收货人"
							  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','consignee')) || (!form['appointment_order_id'] && $check_field('add','consignee'))" :disabled="disabledObj['consignee_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','consignee')">{{form['consignee']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','receiving_phone_number') || $check_field('add','receiving_phone_number') || $check_field('set','receiving_phone_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="收货电话" prop="receiving_phone_number">
												<el-input id="receiving_phone_number" v-model="form['receiving_phone_number']" placeholder="请输入收货电话"
							  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','receiving_phone_number')) || (!form['appointment_order_id'] && $check_field('add','receiving_phone_number'))" :disabled="disabledObj['receiving_phone_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','receiving_phone_number')">{{form['receiving_phone_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','shipping_address') || $check_field('add','shipping_address') || $check_field('set','shipping_address')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="收货地址" prop="shipping_address">
												<el-input id="shipping_address" v-model="form['shipping_address']" placeholder="请输入收货地址"
							  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','shipping_address')) || (!form['appointment_order_id'] && $check_field('add','shipping_address'))" :disabled="disabledObj['shipping_address_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','shipping_address')">{{form['shipping_address']}}</div>
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
				field: "appointment_order_id",
				url_add: "~/api/appointment_order/add?",
				url_set: "~/api/appointment_order/set?",
				url_get_obj: "~/api/appointment_order/get_obj?",
				url_upload: "~/api/appointment_order/upload?",

				query: {
					"appointment_order_id": 0,
				},

				form: {
								"order_number": this.$get_stamp(), // 订单号
										"trade_name":  '', // 商品名称
										"product_type":  '', // 商品类型
										"product_parameters":  '', // 商品参数
										"specifications":  '', // 规格
										"supplier_user": 0, // 供货商用户
										"supplier_name":  '', // 供货商名
										"price":  '', // 价格
										"order_quantity":  0, // 订购数量
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
							"appointment_order_id": 0, // ID
						
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
					          			"order_quantity_isDisabled": false,
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
				
		
		
		
						// 是否鉴定选项列表
				list_whether_to_identify: ['是','否'],
	
						// 鉴定费用选项列表
				list_appraisal_fees: ['0','200'],
	
		
		
					// 用户列表
				list_user_user_name: [],
						// 用户组
				group_user_user_name: "",
								// 取货方式选项列表
				list_pickup_method: ['线下取货','线上发货'],
	
		
		
		
	
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
			
	
			
	
			
	
			
	
										set_order_amount(){
				this.form.order_amount = parseFloat(this.form.price) * parseFloat(this.form.order_quantity)
			},
												
	
			
	
			
	
															set_total_amount(){
				this.form.total_amount = parseFloat(this.form.order_amount) + parseFloat(this.form.appraisal_fees)
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
					bl = this.$check_action('/appointment_order/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/appointment_order/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/appointment_order/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/appointment_order/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/appointment_order/view','get');
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
