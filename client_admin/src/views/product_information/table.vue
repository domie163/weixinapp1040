<template>
	<el-main class="bg table_wrap">
		<el-form label-position="right" :model="query" class="form p_4" label-width="120">
			<el-row>


										<el-col :xs="24" :sm="24" :lg="8" class="el_form_search_wrap">
					<el-form-item label="商品名称">
									<el-input v-model="query.trade_name"></el-input>
								</el-form-item>
				</el-col>
									<el-col :xs="24" :sm="24" :lg="8" class="el_form_search_wrap">
					<el-form-item label="商品类型">
									<el-select v-model="query.product_type">
											<el-option v-for="o in list_product_type" :key="o.product_type" :label="o.product_type"
								:value="o.product_type">
							</el-option>
										</el-select>
								</el-form-item>
				</el-col>
																								<el-col :xs="24" :sm="24" :lg="8" class="el_form_search_wrap">
					<el-form-item label="供货商名">
									<el-input v-model="query.supplier_name"></el-input>
								</el-form-item>
				</el-col>
										<el-col :xs="24" :sm="10" :lg="8" class="search_btn_wrap_1">
					<el-form-item>
						<el-button type="primary" @click="search()" class="search_btn_find">查询</el-button>
						<el-button @click="reset()" style="margin-right: 74px;" class="search_btn_reset">重置</el-button>
						<router-link v-if="user_group == '管理员' || $check_action('/product_information/table','add') || $check_action('/product_information/view','add')" class="el-button el-button--default el-button--primary search_btn_add" to="./view?">添加
						</router-link>
            			<el-button v-if="user_group == '管理员' || $check_action('/product_information/table','del') || $check_action('/product_information/view','del')" class="search_btn_del" type="danger" @click="delInfo()">删除</el-button>
					</el-form-item>
				</el-col>

			</el-row>
		</el-form>
		<el-table :data="list" @selection-change="selectionChange" @sort-change="$sortChange" style="width: 100%" id="dataTable">
			<el-table-column fixed type="selection" tooltip-effect="dark" width="55">
			</el-table-column>
				<el-table-column prop="commodity_map" @sort-change="$sortChange" label="商品图"
				v-if="user_group == '管理员' || $check_field('get','commodity_map')" min-width="200">
						<template slot-scope="scope">
					<el-image style="width: 100px; height: 100px" :src="$fullUrl(scope.row['commodity_map'])"
						:preview-src-list="[$fullUrl(scope.row['commodity_map'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
				</template>
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
					<el-table-column prop="stock" @sort-change="$sortChange" label="库存"
				v-if="user_group == '管理员' || $check_field('get','stock')" min-width="200">
					</el-table-column>
					<el-table-column prop="price" @sort-change="$sortChange" label="价格"
				v-if="user_group == '管理员' || $check_field('get','price')" min-width="200">
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
			
			<el-table-column label="审核状态" prop="examine_state">
			</el-table-column>

			<el-table-column label="审核回复" prop="examine_reply">
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







			<el-table-column fixed="right" label="操作" min-width="120" v-if="user_group == '管理员' || $check_action('/product_information/table','set') || $check_action('/product_information/view','set') || $check_action('/product_information/view','get') || $check_action('/预约订单|直播预约|咨询商家/table','add') || $check_action('/预约订单|直播预约|咨询商家/view','add')" >


				<template slot-scope="scope">
					<router-link class="el-button el-button--small is-plain el-button--success" style="margin: 5px !important;"
					v-if="user_group == '管理员' || $check_action('/product_information/table','set') || $check_action('/product_information/view','set') || $check_action('/product_information/view','get')"
						:to="'./view?' + field + '=' + scope.row[field]"
						 size="small">
						<span>详情</span>
					</router-link>
						<router-link v-if="user_group == '管理员' || $check_comment('/product_information/table')" class="el-button el-button--small is-plain el-button--primary"
								  :to="'../comment/table?size=10&page=1&source_table=product_information&source_field=' + field + '&source_id=' + scope.row[field]" size="small">
					查看评论
					</router-link>
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
				url_get_list: "~/api/product_information/get_list?like=0",
				url_del: "~/api/product_information/del?",

				// 字段ID
				field: "product_information_id",

				// 查询
				query: {
					"size": 7,
					"page": 1,
									"trade_name": "",
											"product_type": "",
																"supplier_name": "",
									"login_time": "",
					"create_time": "",
					"orderby": `create_time desc`
				},

				// 数据
				list: [],
																			// 商品类型列表
				list_product_type: [""],
											// 库存列表
				list_stock: ['1','不限'],
												// 用户列表
				list_user_supplier_user: [],
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
																				if (sqlwhere.length>1){
						sqlwhere = sqlwhere.substr(0,sqlwhere.length-4);
						sqlwhere += ")";
						param["sqlwhere"] = sqlwhere;
					}
					}
				return param;
			},

								/**
			 * 获取商品类型列表
			 */
			async get_list_product_type() {
				var json = await this.$get("~/api/product_type/get_list?");
				if(json.result){
					this.list_product_type = json.result.list;
				}else if (json.error){
					console.log(json.error);
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
									deleteRow(index, rows) {
				rows.splice(index, 1);
			}

		},
		created() {
								// 初始化商品类型列表
			this.get_list_product_type();
																	this.get_list_user_supplier_user();
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
