<template>
	<el-main class="bg table_wrap">
		<el-form label-position="right" :model="query" class="form p_4" label-width="120">
			<el-row>


							<el-col :xs="24" :sm="24" :lg="8" class="el_form_search_wrap">
					<el-form-item label="订单号">
									<el-input v-model="query.order_number"></el-input>
								</el-form-item>
				</el-col>
									<el-col :xs="24" :sm="24" :lg="8" class="el_form_search_wrap">
					<el-form-item label="商品名称">
									<el-input v-model="query.trade_name"></el-input>
								</el-form-item>
				</el-col>
																																													<el-col :xs="24" :sm="24" :lg="8" class="el_form_search_wrap">
					<el-form-item label="取货方式">
									<el-select v-model="query.pickup_method">
				                            <el-option v-for="o in list_pickup_method" :key="o" :label="o"
                            	:value="o">
                            </el-option>
										</el-select>
								</el-form-item>
				</el-col>
																<el-col :xs="24" :sm="10" :lg="8" class="search_btn_wrap_1">
					<el-form-item>
						<el-button type="primary" @click="search()" class="search_btn_find">查询</el-button>
						<el-button @click="reset()" style="margin-right: 74px;" class="search_btn_reset">重置</el-button>
						<router-link v-if="user_group == '管理员' || $check_action('/appointment_order/table','add') || $check_action('/appointment_order/view','add')" class="el-button el-button--default el-button--primary search_btn_add" to="./view?">添加
						</router-link>
            			<el-button v-if="user_group == '管理员' || $check_action('/appointment_order/table','del') || $check_action('/appointment_order/view','del')" class="search_btn_del" type="danger" @click="delInfo()">删除</el-button>
					</el-form-item>
				</el-col>

			</el-row>
		</el-form>
		<el-table :data="list" @selection-change="selectionChange" @sort-change="$sortChange" style="width: 100%" id="dataTable">
			<el-table-column fixed type="selection" tooltip-effect="dark" width="55">
			</el-table-column>
				<el-table-column prop="order_number" @sort-change="$sortChange" label="订单号"
				v-if="user_group == '管理员' || $check_field('get','order_number')" min-width="200">
					</el-table-column>
					<el-table-column prop="trade_name" @sort-change="$sortChange" label="商品名称"
				v-if="user_group == '管理员' || $check_field('get','trade_name')" min-width="200">
					</el-table-column>
					<el-table-column prop="product_type" @sort-change="$sortChange" label="商品类型"
				v-if="user_group == '管理员' || $check_field('get','product_type')" min-width="200">
					</el-table-column>
					<el-table-column prop="product_parameters" @sort-change="$sortChange" label="商品参数"
				v-if="user_group == '管理员' || $check_field('get','product_parameters')" min-width="200">
					</el-table-column>
					<el-table-column prop="specifications" @sort-change="$sortChange" label="规格"
				v-if="user_group == '管理员' || $check_field('get','specifications')" min-width="200">
					</el-table-column>
					<el-table-column prop="supplier_user" @sort-change="$sortChange" label="供货商用户"
				v-if="user_group == '管理员' || $check_field('get','supplier_user')" min-width="200">
						<template slot-scope="scope">
					{{ get_user_supplier_user(scope.row['supplier_user']) }}
				</template>
					</el-table-column>
					<el-table-column prop="supplier_name" @sort-change="$sortChange" label="供货商名"
				v-if="user_group == '管理员' || $check_field('get','supplier_name')" min-width="200">
					</el-table-column>
					<el-table-column prop="price" @sort-change="$sortChange" label="价格"
				v-if="user_group == '管理员' || $check_field('get','price')" min-width="200">
					</el-table-column>
					<el-table-column prop="order_quantity" @sort-change="$sortChange" label="订购数量"
				v-if="user_group == '管理员' || $check_field('get','order_quantity')" min-width="200">
					</el-table-column>
					<el-table-column prop="order_amount" @sort-change="$sortChange" label="订购金额"
				v-if="user_group == '管理员' || $check_field('get','order_amount')" min-width="200">
					</el-table-column>
					<el-table-column prop="whether_to_identify" @sort-change="$sortChange" label="是否鉴定"
				v-if="user_group == '管理员' || $check_field('get','whether_to_identify')" min-width="200">
					</el-table-column>
					<el-table-column prop="appraisal_fees" @sort-change="$sortChange" label="鉴定费用"
				v-if="user_group == '管理员' || $check_field('get','appraisal_fees')" min-width="200">
					</el-table-column>
					<el-table-column prop="total_amount" @sort-change="$sortChange" label="总金额"
				v-if="user_group == '管理员' || $check_field('get','total_amount')" min-width="200">
					</el-table-column>
					<el-table-column prop="user_name" @sort-change="$sortChange" label="用户名称"
				v-if="user_group == '管理员' || $check_field('get','user_name')" min-width="200">
						<template slot-scope="scope">
					{{ get_user_user_name(scope.row['user_name']) }}
				</template>
					</el-table-column>
					<el-table-column prop="pickup_method" @sort-change="$sortChange" label="取货方式"
				v-if="user_group == '管理员' || $check_field('get','pickup_method')" min-width="200">
					</el-table-column>
					<el-table-column prop="consignee" @sort-change="$sortChange" label="收货人"
				v-if="user_group == '管理员' || $check_field('get','consignee')" min-width="200">
					</el-table-column>
					<el-table-column prop="receiving_phone_number" @sort-change="$sortChange" label="收货电话"
				v-if="user_group == '管理员' || $check_field('get','receiving_phone_number')" min-width="200">
					</el-table-column>
					<el-table-column prop="shipping_address" @sort-change="$sortChange" label="收货地址"
				v-if="user_group == '管理员' || $check_field('get','shipping_address')" min-width="200">
					</el-table-column>
	
			<el-table-column label="审核状态" prop="examine_state">
			</el-table-column>

			<el-table-column label="审核回复" prop="examine_reply">
			</el-table-column>

			<el-table-column label="支付状态" prop="pay_state">
			</el-table-column>

			<el-table-column label="支付类型" prop="pay_type">
			</el-table-column>

            <el-table-column sortable prop="create_time" label="创建时间" min-width="200">
                <template slot-scope="scope">
                	{{ $toTime(scope.row["create_time"],"yyyy-MM-dd hh:mm:ss") }}
                </template>
            </el-table-column>

			<el-table-column sortable prop="update_time" label="更新时间" min-width="200">
                <template slot-scope="scope">
                	{{ $toTime(scope.row["update_time"],"yyyy-MM-dd hh:mm:ss") }}
                </template>
			</el-table-column>







			<el-table-column fixed="right" label="操作" min-width="120" v-if="user_group == '管理员' || $check_action('/appointment_order/table','set') || $check_action('/appointment_order/view','set') || $check_action('/appointment_order/view','get') || $check_action('/收货确认|取消订单/table','add') || $check_action('/收货确认|取消订单/view','add')" >


				<template slot-scope="scope">
					<router-link class="el-button el-button--small is-plain el-button--success" style="margin: 5px !important;"
					v-if="user_group == '管理员' || $check_action('/appointment_order/table','set') || $check_action('/appointment_order/view','set') || $check_action('/appointment_order/view','get')"
						:to="'./view?' + field + '=' + scope.row[field]"
						 size="small">
						<span>详情</span>
					</router-link>
						<!--跨表按钮-->
							<el-button class="el-button el-button--small is-plain el-button--default" style="margin: 5px !important;" size="small" @click="to_table(scope.row,'/receiving_records/view')" v-if="user_group == '管理员' || $check_action('/receiving_records/table','add') || $check_action('/receiving_records/view','add')">
						<span>收货确认</span>
					</el-button>
							<el-button class="el-button el-button--small is-plain el-button--default" style="margin: 5px !important;" size="small" @click="to_table(scope.row,'/cancellation_of_order/view')" v-if="user_group == '管理员' || $check_action('/cancellation_of_order/table','add') || $check_action('/cancellation_of_order/view','add')">
						<span>取消订单</span>
					</el-button>
								<el-button class="el-button el-button--small is-plain el-button--default" style="margin: 5px !important;" size="small" @click="openPayModal(scope.row)" v-if="scope.row.pay_state==='未支付' && (user_group == '管理员' || $check_pay('/appointment_order/table'))">
						<span>支付</span>
					</el-button>
				</template>
			</el-table-column>

		</el-table>

		<!-- 分页器 -->
		<div class="mt text_center">
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
				:current-page="query.page" :page-sizes="[7, 10, 30, 100]" :page-size="query.size"
				layout="total, sizes, prev, pager, next, jumper" :total="count">
			</el-pagination>
		</div>
		<!-- /分页器 -->

																				<el-dialog
				title="支付"
				:visible.sync="payModalVisible"
				width="500px"
		>
			<el-tabs v-model="pay_obj.payActiveName" :stretch="true">
				<el-tab-pane label="微信" name="微信">
					<div style="width: 80%;margin: 0 auto;">
						<div style="width: 60%;margin: 30px auto;">
							<el-image style="width: 100%;" :src="$fullUrl('/api/upload/wx.png')"
									  :preview-src-list="[$fullUrl('/api/upload/wx.png')]">
								<div slot="error" class="image-slot">
									<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
								</div>
							</el-image>
						</div>
						<div style="width: 80%;margin: 0 auto;">
							<div style="width: 100%;background-color: #409EFF;color: white;font-size: 14px;text-align: center;line-height: 40px;cursor: pointer" @click="submitPay()">确认支付</div>
						</div>
					</div>
				</el-tab-pane>
				<el-tab-pane label="支付宝" name="支付宝">
					<div style="width: 80%;margin: 0 auto;">
						<div style="width: 60%;margin: 30px auto;">
							<el-image style="width: 100%;" :src="$fullUrl('/api/upload/aplipay.png')"
									  :preview-src-list="[$fullUrl('/api/upload/aplipay.png')]">
								<div slot="error" class="image-slot">
									<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
								</div>
							</el-image>
						</div>
						<div style="width: 80%;margin: 0 auto;">
							<div style="width: 100%;background-color: #409EFF;color: white;font-size: 14px;text-align: center;line-height: 40px;cursor: pointer" @click="submitPay()">确认支付</div>
						</div>
					</div>
				</el-tab-pane>
				<el-tab-pane label="网银" name="网银">
					<div style="width: 80%;margin: 0 auto;margin-top: 30px;">
						<div style="width: 80%;margin: 0 auto;">
							<div style="line-height: 40px">请输入网银账号：</div>
						</div>
						<div style="width: 80%;margin: 0 auto;">
							<el-input v-model="pay_obj.account" placeholder="请输入网银账号"></el-input>
						</div>
					</div>
					<div style="width: 80%;margin: 0 auto;margin-top: 20px;">
						<div style="width: 80%;margin: 0 auto;">
							<div style="line-height: 40px">请输入支付密码，6位数字：</div>
						</div>
						<div style="width: 80%;margin: 0 auto;">
							<el-input placeholder="请输入密码" v-model="pay_obj.password" show-password maxlength="6"></el-input>
						</div>
					</div>
					<div style="width: 80%;margin: 0 auto;margin-top: 40px;">
						<div style="width: 100%;background-color: #409EFF;color: white;font-size: 14px;text-align: center;line-height: 40px;cursor: pointer" @click="submitPay()">确认支付</div>
					</div>
				</el-tab-pane>
			</el-tabs>
		</el-dialog>

		<div class="modal_wrap" v-if="showModal">
			<div class="modal_box">
				<!-- <div class="modal_box_close" @click="closeModal">X</div> -->
				<p class="modal_box_title">重要提醒</p>
				<p class="modal_box_text">当前有数据达到预警值！</p>
				<div class="btn_box">
					<span @click="closeModal">取消</span>
					<span @click="closeModal">确定</span>
				</div>
			</div>
		</div>


	</el-main>
</template>
<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				// 弹框
				showModal: false,
				// 获取数据地址
				url_get_list: "~/api/appointment_order/get_list?like=0",
				url_del: "~/api/appointment_order/del?",

				// 字段ID
				field: "appointment_order_id",

				// 查询
				query: {
					"size": 7,
					"page": 1,
								"order_number": "",
											"trade_name": "",
																							"pickup_method": "",
											"login_time": "",
					"create_time": "",
					"orderby": `create_time desc`
				},

				// 数据
				list: [],
				payModalVisible:false,
				pay_obj:{
					payActiveName:"微信",
					account:"",
					password:"",
					id:""
				},
																																				// 用户列表
				list_user_supplier_user: [],
														// 是否鉴定列表
				list_whether_to_identify: ['是','否'],
							// 鉴定费用列表
				list_appraisal_fees: ['0','200'],
												// 用户列表
				list_user_user_name: [],
						// 取货方式列表
				list_pickup_method: ['线下取货','线上发货'],
											}
		},
		methods: {
			// 关闭弹框
			closeModal(){
				this.showModal = false;
				},

			get_list_before(param){
				var user_group = this.user.user_group;
				if(user_group != "管理员"){
						let sqlwhere = "(";
																																			if(user_group=="供货商"){
						sqlwhere+= "supplier_user = " + this.user.user_id + " or ";
					}
																																																if(user_group=="普通用户"){
						sqlwhere+= "user_name = " + this.user.user_id + " or ";
					}
																														if (sqlwhere.length>1){
						sqlwhere = sqlwhere.substr(0,sqlwhere.length-4);
						sqlwhere += ")";
						param["sqlwhere"] = sqlwhere;
					}
					}
				return param;
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
				var obj = this.list_user_supplier_user.getObj({"user_id":id});
				var ret = "";
				if(obj){
					ret = obj.nickname+"-"+obj.username;
					// if(obj.nickname){
					// 	ret = obj.nickname;
					// }
					// else{
					// 	ret = obj.username;
					// }
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
				var obj = this.list_user_user_name.getObj({"user_id":id});
				var ret = "";
				if(obj){
					ret = obj.nickname+"-"+obj.username;
					// if(obj.nickname){
					// 	ret = obj.nickname;
					// }
					// else{
					// 	ret = obj.username;
					// }
				}
				return ret;
			},
													openPayModal(v){
				this.pay_obj.id = v.appointment_order_id
				this.payModalVisible = true
			},
			submitPay(){
				let _this = this;
				let url = this.$toUrl(this.query, "~/api/appointment_order/set?appointment_order_id="+this.pay_obj.id);
				let param = {"pay_state":"已支付","pay_type":this.pay_obj.payActiveName}
				this.$post(url, param, function(json, status) {
					console.log("提交结果：" ,json);
					if (json.result) {
						_this.$toast('支付成功！', 'success');
						_this.payModalVisible = false;
						_this.get_list();
					} else if (json.error) {
						_this.$toast(json.error.message, 'danger');
					}
				});
			},
			deleteRow(index, rows) {
				rows.splice(index, 1);
			}

		},
		created() {
																	this.get_list_user_supplier_user();
																						this.get_list_user_user_name();
											}
	}
</script>

<style type="text/css">
	.bg {
		background: white;
	}

	.form.p_4 {
		padding: 1rem;
	}

	.form .el-input {
		width: initial;
	}

	.mt {
		margin-top: 1rem;
	}

	.text_center {
		text-align: center;
	}

	.float-right {
		float: right;
	}


	.modal_wrap{
		width: 100vw;
		height: 100vh;
		position: fixed;
		top: 0;
		left: 0;
		background: rgba(0,0,0,0.5);
		z-index: 9999999999;
	}
	.modal_wrap .modal_box{
		width: 400px;
		height: 200px;
		background: url("../../assets/modal_bg.jpg") no-repeat center;
		background-size: cover;
		position: absolute;
		top: 50%;
		left: 50%;
		margin-left: -200px;
		margin-top: -100px;
		border-radius: 10px;
		}
	.modal_wrap .modal_box .modal_box_close{
		font-size: 20px;
		position: absolute;
		top: 10px;
		right: 10px;
		cursor: pointer;
		}
	.modal_wrap .modal_box .modal_box_title{
	  text-align: center;
    font-size: 18px;
    margin: 16px auto;
    color: #fff;
    border-bottom: 1px solid rgba(117, 116, 116,0.5);
    padding-bottom: 16px;
    width: 356px;
		}
	.modal_wrap .modal_box .modal_box_text{
			text-align: center;
		font-size: 15px;
		color: #fff;
		margin-top: 25px;
		}
	.modal_wrap .modal_box .btn_box{
		display: flex;
		flex-direction: row;
		justify-content: center;
		margin-top: 42px;
		}
			.modal_wrap .modal_box .btn_box span{
				display: inline-block;
				width: 80px;
				height: 30px;
				line-height: 30px;
				text-align: center;
				border: 1px solid #ccc;
				font-size: 14px;
				cursor: pointer;
				color: #fff;
			}
	.modal_wrap .modal_box .btn_box span:nth-child(2){
		background: #409EFF;
		color: #fff;
		border-color: #409EFF;
		margin-left: 15px;
	}
</style>
