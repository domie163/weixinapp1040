<template>
	<view class="list_after_sales_application list_com--new" style="background-color: #fff;">
		<!-- 视图 -->
		<view class="after_sales_application_block box_wrap" >
			<navigator class="item_after_sales_application box_style" v-for="(o, i) in list"  :key="i" :url="'/pages/after_sales_application/details?after_sales_application_id=' + o['after_sales_application_id']">
					<view class="view" v-if="1 && $check_index_field('get','order_number','/after_sales_application/list')">
					<view class="title" v-if="true">
						<span>订单号</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["order_number"] }}</span>
					</view>
						</view>
						<view class="view" v-if="1 && $check_index_field('get','trade_name','/after_sales_application/list')">
					<view class="title" v-if="true">
						<span>商品名称</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["trade_name"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','product_type','/after_sales_application/list')">
					<view class="title" v-if="true">
						<span>商品类型</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["product_type"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','supplier_user','/after_sales_application/list')">
					<view class="title" v-if="true">
						<span>供货商用户</span>
					</view>
							<view class="diy_field time" >
						<span>{{ get_user_supplier_user(o['supplier_user']) }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','supplier_name','/after_sales_application/list')">
					<view class="title" v-if="true">
						<span>供货商名</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["supplier_name"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','after_sales_quantity','/after_sales_application/list')">
					<view class="title" v-if="true">
						<span>售后数量</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["after_sales_quantity"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','user_name','/after_sales_application/list')">
					<view class="title" v-if="true">
						<span>用户名称</span>
					</view>
							<view class="diy_field time" >
						<span>{{ get_user_user_name(o['user_name']) }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','consignee','/after_sales_application/list')">
					<view class="title" v-if="true">
						<span>收货人</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["consignee"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','receiving_phone_number','/after_sales_application/list')">
					<view class="title" v-if="true">
						<span>收货电话</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["receiving_phone_number"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','shipping_address','/after_sales_application/list')">
					<view class="title" v-if="true">
						<span>收货地址</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["shipping_address"] }}</span>
					</view>
						</view>
						<view class="view" v-if="1 && $check_index_field('get','after_sales_issues','/after_sales_application/list')">
					<view class="title" v-if="true">
						<span>售后问题</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["after_sales_issues"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','problem_description','/after_sales_application/list')">
					<view class="title" v-if="true">
						<span>问题描述</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["problem_description"] }}</span>
					</view>
						</view>
					<view class="bottom-view">
				</view>
				<view class="view">
					<view class="create_time_block diy_field number">
						<span>{{ $toTime(o["create_time"],"yyyy-MM-dd hh:mm:ss") }}</span>
					</view>
				</view>
			</navigator>
		</view>
		<!-- /视图 -->
	</view>
</template>

<script>
	export default {
		props: {
			list: {
				type: Array,
				default: function() {
					return [];
				}
			}
		},
		data() {
			return {
								// 用户列表
				list_user_supplier_user: [],
								// 用户列表
				list_user_user_name: [],
									}
		},
		methods: {
			/**
			 *  跳转链接
			 *  @param {Object} id
			 */
			to_nav(id) {
				this.$nav('/pages/after_sales_application/details?after_sales_application_id=' + id)
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
								}
	}
</script>

<style scoped>
	.list_after_sales_application {
		/* padding: 0 1rem; */
		margin-bottom: 1rem;
	}

	.list_after_sales_application .list_after_sales_application_table {
		width: 100%;
		padding: 5px 0;
	}

	.list_after_sales_application .list_after_sales_application_table .btn_change_table {
		margin-left: auto;
		font-weight: bold;
		padding: 0.5rem 0;
		width: 100px;
		text-align: center;
		font-size: 0.875rem;
		border: 1px solid #CCCCCC;
		border-radius: 1rem;
		margin-bottom: 0.25rem;
	}

	.list_after_sales_application .list_after_sales_application_table .after_sales_application_table_block .uni-table-td{
		padding: 8px;
	}

	.list_after_sales_application .list_after_sales_application_table .after_sales_application_table_block .image {
		width: 10%;
	}

	.list_after_sales_application .list_after_sales_application_table .after_sales_application_table_block .text {
		overflow: hidden;
		width: 30%;
		font-size: 0.5rem;
	}

	.list_after_sales_application .list_after_sales_application_table .after_sales_application_table_block .hits {
		width: 12%;
		font-size: 0.5rem;
	}

	.list_after_sales_application .list_after_sales_application_table .after_sales_application_table_block .praise {
		width: 12%;
		font-size: 0.5rem;
	}

	.list_after_sales_application .list_after_sales_application_table .after_sales_application_table_block .create_time {
		width: 26%;
		font-size: 0.5rem;
	}
	.list_after_sales_application .item_after_sales_application {
		display: flex;
		justify-content: space-between;
		align-items: stretch;
		padding: 0.75rem 1rem;

	}
	.list_after_sales_application .item_after_sales_application+.item_after_sales_application{
		border-top: 1px solid #dbdbdb;
	}
	.list_after_sales_application .item_after_sales_application .left>image {
		position: relative;
		top: 50%;
		transform: translate(0, -50%);
		border-radius: 0.5rem;
	}

	.list_after_sales_application .item_after_sales_application .right_block {
		width: calc(100% - 5rem);
		display: flex;
		flex-direction: column;
		justify-content: space-between;
	}

	.list_after_sales_application .top {
		font-size: 0.9rem;
	}


	.list_after_sales_application .time {
		font-size: 0.6rem;
		color: var(--color_grey)
	}

	.list_after_sales_application .bottom {
		display: flex;
		justify-content: space-between;
		align-items: baseline;
		font-size: 0.5rem;
		color: var(--color_grey)
	}

	.list_after_sales_application .see {
		margin-left: 1rem;
	}
	.box_wrap{
		padding: 0.75rem;
	}
	.box_style{
		margin-bottom: 0.75rem;
		padding: 0.375rem;
		display: inline-block !important;
		border: 0.075rem solid #ccc;
		border-radius: 0.375rem;
		overflow: hidden;
	}
	.box_style:nth-child(even){
		margin-left: 0.60rem;
	}
	.box_style:nth-child(even){
		margin-left: 0.60rem;
	}
	.bottom-view,.create_time_block{
		font-size: 12px;
		color: #666666;
	}
	.bottom-view view{
		display: inline-block;
	}
	.bottom-view span{
		margin-left: 5px;
		margin-right: 10px;
	}
/* new style start */
	.list_com--new .box_wrap{
		display: flex;
		flex-wrap: wrap;
		padding-left: 0 !important;
		padding-right: 0 !important;
		justify-content: space-between;
	}
	.list_com--new .box_style:nth-child(even) {
    	margin-left: 0 !important;
	}
    .list_com--new .box_wrap .box_style{
		display: inline-block !important;
		width: 48%;
		max-width: 48%;
		overflow: hidden;
		border-color: var(--color_primary);
		box-sizing: border-box;
		padding:8px!important;
    }
    .list_com--new .view{
        display: flex;
        overflow: hidden;
		width:100%;
    }

    .list_com--new .view .title span{
       white-space: nowrap;
    }
    .list_com--new .view .text{
        display: flex;
        color: var(--color_primary);
        margin-left: 10px;
        border-bottom: 1px solid #ccc;
        white-space: nowrap;
    }
     .list_com--new .view .text span{
        max-width: 100px;
        overflow: hidden;
        text-overflow: ellipsis;
    }

     .list_com--new .view .number{
        color: var(--color_primary);
    }

    .list_com--new .view .image{
        width: 100%;
        border-bottom: 1px solid #ccc;
		margin-top:5px;
    }

	.list_com--new .diy_field.text{
		overflow: hidden;
		margin-right: -8px;
	}

/* new style start */

</style>

