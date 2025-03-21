<template>
  <view>
    <view class="container diy_view">
      <view>
        <view>
          <view class="">
            <uni-forms :modelValue="form"  v-if="is_view()">

              <uni-forms-item v-if="$check_field('get','order_number') || ($check_field('add','order_number') || $check_field('set','order_number'))" label="订单号" name="order_number">
                            <uni-easyinput type="text" v-model="form['order_number']" v-if="user_group === '管理员' || (form['cancel_confirmation_id'] && $check_field('set','order_number')) || (!form['cancel_confirmation_id'] && $check_field('add','order_number'))" :disabled="disabledObj['order_number_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','order_number')">
                  {{ form['order_number'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','trade_name') || ($check_field('add','trade_name') || $check_field('set','trade_name'))" label="商品名称" name="trade_name">
                            <uni-easyinput type="text" v-model="form['trade_name']" v-if="user_group === '管理员' || (form['cancel_confirmation_id'] && $check_field('set','trade_name')) || (!form['cancel_confirmation_id'] && $check_field('add','trade_name'))" :disabled="disabledObj['trade_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','trade_name')">
                  {{ form['trade_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','product_type') || ($check_field('add','product_type') || $check_field('set','product_type'))" label="商品类型" name="product_type">
                            <uni-easyinput type="text" v-model="form['product_type']" v-if="user_group === '管理员' || (form['cancel_confirmation_id'] && $check_field('set','product_type')) || (!form['cancel_confirmation_id'] && $check_field('add','product_type'))" :disabled="disabledObj['product_type_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','product_type')">
                  {{ form['product_type'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','supplier_user') || ($check_field('add','supplier_user') || $check_field('set','supplier_user'))" label="供货商用户" name="supplier_user">
                    <uni-data-select
                  id="form_supplier_user"
                  v-model="form['supplier_user']"
                  :localdata="list_user_supplier_user"
                  :clear="!disabledObj['supplier_user_isDisabled']"
                  :disabled="disabledObj['supplier_user_isDisabled']"
                  v-if="user_group === '管理员' || (form['cancel_confirmation_id'] && $check_field('set','supplier_user')) || (!form['cancel_confirmation_id'] && $check_field('add','supplier_user'))"
                ></uni-data-select>
                <uni-data-select
                  v-model="form['supplier_user']"
                  :localdata="list_user_supplier_user"
                  :clear="false"
                  :disabled="true"
                  v-else-if="$check_field('get','supplier_user')" id="supplier_user"
                ></uni-data-select>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','supplier_name') || ($check_field('add','supplier_name') || $check_field('set','supplier_name'))" label="供货商名" name="supplier_name">
                            <uni-easyinput type="text" v-model="form['supplier_name']" v-if="user_group === '管理员' || (form['cancel_confirmation_id'] && $check_field('set','supplier_name')) || (!form['cancel_confirmation_id'] && $check_field('add','supplier_name'))" :disabled="disabledObj['supplier_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','supplier_name')">
                  {{ form['supplier_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','price') || ($check_field('add','price') || $check_field('set','price'))" label="价格" name="price">
                            <uni-easyinput type="text" v-model="form['price']" v-if="user_group === '管理员' || (form['cancel_confirmation_id'] && $check_field('set','price')) || (!form['cancel_confirmation_id'] && $check_field('add','price'))" :disabled="disabledObj['price_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','price')">
                  {{ form['price'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','order_quantity') || ($check_field('add','order_quantity') || $check_field('set','order_quantity'))" label="订购数量" name="order_quantity">
                            <uni-easyinput type="text" v-model="form['order_quantity']" v-if="user_group === '管理员' || (form['cancel_confirmation_id'] && $check_field('set','order_quantity')) || (!form['cancel_confirmation_id'] && $check_field('add','order_quantity'))" :disabled="disabledObj['order_quantity_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','order_quantity')">
                  {{ form['order_quantity'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','order_amount') || ($check_field('add','order_amount') || $check_field('set','order_amount'))" label="订购金额" name="order_amount">
                            <uni-easyinput type="text" v-model="form['order_amount']" v-if="user_group === '管理员' || (form['cancel_confirmation_id'] && $check_field('set','order_amount')) || (!form['cancel_confirmation_id'] && $check_field('add','order_amount'))"  @focus="set_order_amount()" :disabled="disabledObj['order_amount_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','order_amount')">
                  {{ form['order_amount'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','total_amount') || ($check_field('add','total_amount') || $check_field('set','total_amount'))" label="总金额" name="total_amount">
                            <uni-easyinput type="text" v-model="form['total_amount']" v-if="user_group === '管理员' || (form['cancel_confirmation_id'] && $check_field('set','total_amount')) || (!form['cancel_confirmation_id'] && $check_field('add','total_amount'))"  @focus="set_total_amount()" :disabled="disabledObj['total_amount_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','total_amount')">
                  {{ form['total_amount'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','user_name') || ($check_field('add','user_name') || $check_field('set','user_name'))" label="用户名称" name="user_name">
                    <uni-data-select
                  id="form_user_name"
                  v-model="form['user_name']"
                  :localdata="list_user_user_name"
                  :clear="!disabledObj['user_name_isDisabled']"
                  :disabled="disabledObj['user_name_isDisabled']"
                  v-if="user_group === '管理员' || (form['cancel_confirmation_id'] && $check_field('set','user_name')) || (!form['cancel_confirmation_id'] && $check_field('add','user_name'))"
                ></uni-data-select>
                <uni-data-select
                  v-model="form['user_name']"
                  :localdata="list_user_user_name"
                  :clear="false"
                  :disabled="true"
                  v-else-if="$check_field('get','user_name')" id="user_name"
                ></uni-data-select>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','reason_for_cancellation') || ($check_field('add','reason_for_cancellation') || $check_field('set','reason_for_cancellation'))" label="取消原因" name="reason_for_cancellation">
                    <uni-easyinput type="textarea" v-model="form['reason_for_cancellation']" v-if="user_group === '管理员' || (form['cancel_confirmation_id'] && $check_field('set','reason_for_cancellation')) || (!form['cancel_confirmation_id'] && $check_field('add','reason_for_cancellation'))" :disabled="disabledObj['reason_for_cancellation_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','reason_for_cancellation')">
                  {{ form['reason_for_cancellation'] }}
                </text>
                  </uni-forms-item>


            </uni-forms>
            <view class="form_button">
              <button size="mini" type="primary" @click="submit()" class="primary_btn">提交</button>
              <button size="mini" @click="cancel()">取消</button>
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
  mixins: [mixin],
  data() {
    return {
      field: "cancel_confirmation_id",
      url_add: "~/api/cancel_confirmation/add?",
      url_set: "~/api/cancel_confirmation/set?",
      url_get_obj: "~/api/cancel_confirmation/get_obj?",
      url_upload: "~/api/cancel_confirmation/upload?",

      query: {
        "cancel_confirmation_id": 0,
      },

      form: {
            "order_number":  '', // 订单号
                    "trade_name":  '', // 商品名称
                    "product_type":  '', // 商品类型
                    "supplier_user": 0, // 供货商用户
                    "supplier_name":  '', // 供货商名
                    "price":  '', // 价格
                    "order_quantity":  '', // 订购数量
                    "order_amount":  '', // 订购金额
                    "total_amount":  '', // 总金额
                    "user_name": 0, // 用户名称
                    "reason_for_cancellation":  '', // 取消原因
                                "cancel_confirmation_id": 0, // ID
                
              },
          disabledObj:{
                        "order_number_isDisabled": false,
                                "trade_name_isDisabled": false,
                                "product_type_isDisabled": false,
                                "supplier_user_isDisabled": false,
                                "supplier_name_isDisabled": false,
                                "price_isDisabled": false,
                                "order_quantity_isDisabled": false,
                                "order_amount_isDisabled": false,
                                "total_amount_isDisabled": false,
                                "user_name_isDisabled": false,
                                "reason_for_cancellation_isDisabled": false,
                                  },
                                                                                            // 用户列表
            list_user_supplier_user: [],
                                                                                                                                                        // 用户列表
            list_user_user_name: [],
                                                              }
  },
  methods: {
    changeLog(v,value){
      this.form[value] = v
    },
    /**
     * 上传文件
     * @param {Object} param文件参数
     */
    change_file(key_name){
      var _self = this;
      // 选择图像方法
      uni.chooseFile({
        count: 1,
        sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
        sourceType: ['album'], //从相册选择
        success: function(res) {
          const tempFilePaths = res.tempFilePaths;
          const uploadTask = uni.uploadFile({
            url: _self.$fullUrl('/api/cancel_confirmation/upload?'),
            filePath: tempFilePaths[0],
            name: 'file',
            formData: {
              'i_want_to_customize': 'test'
            },
            header: {
              'x-auth-token': _self.$store.state.user.token
            },
            success: function(uploadFileRes) {
              var filename = JSON.parse(uploadFileRes.data).result.url
              _self.form[key_name] = filename
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
     * 上传图片
     * @param {Object} param文件参数
     */
    change_img(key_name){
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
            url: _self.$fullUrl('/api/cancel_confirmation/upload?'),
            filePath: tempFilePaths[0],
            name: 'file',
            formData: {
              'i_want_to_customize': 'test'
            },
            header: {
              'x-auth-token': _self.$store.state.user.token
            },
            success: function(uploadFileRes) {
              var filename = JSON.parse(uploadFileRes.data).result.url
              _self.form[key_name] = filename
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
                                                    
                                                set_total_amount(){
      this.form.total_amount = parseFloat(this.form.order_amount) + parseFloat(this.form.鉴定费用)
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
            
            
    
    /**
     * 获取对象之后
     * @param {Object} json
     * @param {Object} func
     */
    get_obj_after(json, func){
                                                                                            },

    is_view(){
      var bl = this.user_group == "管理员";

      if(!bl){
        bl = this.$check_action('/cancel_confirmation/table','add');
        console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
      }
      if(!bl){
        bl = this.$check_action('/cancel_confirmation/table','set');
        console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
      }
      if(!bl){
        bl = this.$check_action('/cancel_confirmation/view','add');
        console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
      }
      if(!bl){
        bl = this.$check_action('/cancel_confirmation/view','set');
        console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
      }
      if(!bl){
        bl = this.$check_action('/cancel_confirmation/view','get');
        console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
      }

      console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

      return bl;
    },

  },
  created() {
                                    this.get_list_user_supplier_user();
                                                                this.get_list_user_user_name();
                      },
}
</script>

<style scoped>
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

.form_button{
  padding-bottom: 15px;
  display: flex;
}
.form_button button{
  width: 40%;
}
.query_select{
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

.query_option{
  width: 100%;
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
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}

.form_button {
  padding-bottom: 15px;
  display: flex;
}
.form_button button {
  width: 40%;
}
.query_select {
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
  outline: none;
}

.query_option {
  width: 100%;
}

.btn_add_img {
  color: #d3d3d3;
  text-align: center;
  border: 1px solid #eee;
  height: 5rem;
  width: 5rem;
  position: relative;
}
.btn_add_img text {
  font-size: 35px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
/*新样式*/
.uni-forms{
padding-top:1rem;
}
.uni-forms-item {
	padding: 6px 10px;
    background: #f8f6fc;
}
.uni-forms .is-input-border{
	border: 0;
}
.container{
	    -webkit-box-shadow: 0px 0px 0px #888888;
	    box-shadow: 0px 0px 0px #888888;
}
.form_button .primary_btn{
		background-color: #22B8B8;
		color: #FFFFFF;
	}
</style>
