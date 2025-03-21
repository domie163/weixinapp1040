<template>
  <view>
    <view class="container diy_view">
      <view>
        <view>
          <view class="">
            <uni-forms :modelValue="form"  v-if="is_view()">

              <uni-forms-item v-if="$check_field('get','order_number') || ($check_field('add','order_number') || $check_field('set','order_number'))" label="订单号" name="order_number">
                            <uni-easyinput type="text" v-model="form['order_number']" v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','order_number')) || (!form['appointment_order_id'] && $check_field('add','order_number'))"  :disabled="true" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','order_number')">
                  {{ form['order_number'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','trade_name') || ($check_field('add','trade_name') || $check_field('set','trade_name'))" label="商品名称" name="trade_name">
                            <uni-easyinput type="text" v-model="form['trade_name']" v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','trade_name')) || (!form['appointment_order_id'] && $check_field('add','trade_name'))" :disabled="disabledObj['trade_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','trade_name')">
                  {{ form['trade_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','product_type') || ($check_field('add','product_type') || $check_field('set','product_type'))" label="商品类型" name="product_type">
                            <uni-easyinput type="text" v-model="form['product_type']" v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','product_type')) || (!form['appointment_order_id'] && $check_field('add','product_type'))" :disabled="disabledObj['product_type_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','product_type')">
                  {{ form['product_type'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','product_parameters') || ($check_field('add','product_parameters') || $check_field('set','product_parameters'))" label="商品参数" name="product_parameters">
                            <uni-easyinput type="text" v-model="form['product_parameters']" v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','product_parameters')) || (!form['appointment_order_id'] && $check_field('add','product_parameters'))" :disabled="disabledObj['product_parameters_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','product_parameters')">
                  {{ form['product_parameters'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','specifications') || ($check_field('add','specifications') || $check_field('set','specifications'))" label="规格" name="specifications">
                            <uni-easyinput type="text" v-model="form['specifications']" v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','specifications')) || (!form['appointment_order_id'] && $check_field('add','specifications'))" :disabled="disabledObj['specifications_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','specifications')">
                  {{ form['specifications'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','supplier_user') || ($check_field('add','supplier_user') || $check_field('set','supplier_user'))" label="供货商用户" name="supplier_user">
                    <uni-data-select
                  id="form_supplier_user"
                  v-model="form['supplier_user']"
                  :localdata="list_user_supplier_user"
                  :clear="!disabledObj['supplier_user_isDisabled']"
                  :disabled="disabledObj['supplier_user_isDisabled']"
                  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','supplier_user')) || (!form['appointment_order_id'] && $check_field('add','supplier_user'))"
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
                            <uni-easyinput type="text" v-model="form['supplier_name']" v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','supplier_name')) || (!form['appointment_order_id'] && $check_field('add','supplier_name'))" :disabled="disabledObj['supplier_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','supplier_name')">
                  {{ form['supplier_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','price') || ($check_field('add','price') || $check_field('set','price'))" label="价格" name="price">
                            <uni-easyinput type="text" v-model="form['price']" v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','price')) || (!form['appointment_order_id'] && $check_field('add','price'))" :disabled="disabledObj['price_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','price')">
                  {{ form['price'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','order_quantity') || ($check_field('add','order_quantity') || $check_field('set','order_quantity'))" label="订购数量" name="order_quantity">
                            <uni-easyinput type="text" v-model="form['order_quantity']" v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','order_quantity')) || (!form['appointment_order_id'] && $check_field('add','order_quantity'))" :disabled="disabledObj['order_quantity_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','order_quantity')">
                  {{ form['order_quantity'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','order_amount') || ($check_field('add','order_amount') || $check_field('set','order_amount'))" label="订购金额" name="order_amount">
                            <uni-easyinput type="text" v-model="form['order_amount']" v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','order_amount')) || (!form['appointment_order_id'] && $check_field('add','order_amount'))"  @focus="set_order_amount()" :disabled="disabledObj['order_amount_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','order_amount')">
                  {{ form['order_amount'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','whether_to_identify') || ($check_field('add','whether_to_identify') || $check_field('set','whether_to_identify'))" label="是否鉴定" name="whether_to_identify">
                    <uni-data-select
                  v-model="form.whether_to_identify"
                  :localdata="list_whether_to_identify"
                  :clear="!disabledObj['whether_to_identify_isDisabled']"
                  :disabled="disabledObj['whether_to_identify_isDisabled']"
                  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','whether_to_identify')) || (!form['appointment_order_id'] && $check_field('add','whether_to_identify'))"
                ></uni-data-select>
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','whether_to_identify')">
                  {{ form['whether_to_identify'] }}
                </text>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','appraisal_fees') || ($check_field('add','appraisal_fees') || $check_field('set','appraisal_fees'))" label="鉴定费用" name="appraisal_fees">
                    <uni-data-select
                  v-model="form.appraisal_fees"
                  :localdata="list_appraisal_fees"
                  :clear="!disabledObj['appraisal_fees_isDisabled']"
                  :disabled="disabledObj['appraisal_fees_isDisabled']"
                  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','appraisal_fees')) || (!form['appointment_order_id'] && $check_field('add','appraisal_fees'))"
                ></uni-data-select>
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','appraisal_fees')">
                  {{ form['appraisal_fees'] }}
                </text>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','total_amount') || ($check_field('add','total_amount') || $check_field('set','total_amount'))" label="总金额" name="total_amount">
                            <uni-easyinput type="text" v-model="form['total_amount']" v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','total_amount')) || (!form['appointment_order_id'] && $check_field('add','total_amount'))"  @focus="set_total_amount()" :disabled="disabledObj['total_amount_isDisabled']" />
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
                  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','user_name')) || (!form['appointment_order_id'] && $check_field('add','user_name'))"
                ></uni-data-select>
                <uni-data-select
                  v-model="form['user_name']"
                  :localdata="list_user_user_name"
                  :clear="false"
                  :disabled="true"
                  v-else-if="$check_field('get','user_name')" id="user_name"
                ></uni-data-select>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','pickup_method') || ($check_field('add','pickup_method') || $check_field('set','pickup_method'))" label="取货方式" name="pickup_method">
                    <uni-data-select
                  v-model="form.pickup_method"
                  :localdata="list_pickup_method"
                  :clear="!disabledObj['pickup_method_isDisabled']"
                  :disabled="disabledObj['pickup_method_isDisabled']"
                  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','pickup_method')) || (!form['appointment_order_id'] && $check_field('add','pickup_method'))"
                ></uni-data-select>
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','pickup_method')">
                  {{ form['pickup_method'] }}
                </text>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','consignee') || ($check_field('add','consignee') || $check_field('set','consignee'))" label="收货人" name="consignee">
                            <uni-easyinput type="text" v-model="form['consignee']" v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','consignee')) || (!form['appointment_order_id'] && $check_field('add','consignee'))" :disabled="disabledObj['consignee_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','consignee')">
                  {{ form['consignee'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','receiving_phone_number') || ($check_field('add','receiving_phone_number') || $check_field('set','receiving_phone_number'))" label="收货电话" name="receiving_phone_number">
                            <uni-easyinput type="text" v-model="form['receiving_phone_number']" v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','receiving_phone_number')) || (!form['appointment_order_id'] && $check_field('add','receiving_phone_number'))" :disabled="disabledObj['receiving_phone_number_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','receiving_phone_number')">
                  {{ form['receiving_phone_number'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','shipping_address') || ($check_field('add','shipping_address') || $check_field('set','shipping_address'))" label="收货地址" name="shipping_address">
                            <uni-easyinput type="text" v-model="form['shipping_address']" v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','shipping_address')) || (!form['appointment_order_id'] && $check_field('add','shipping_address'))" :disabled="disabledObj['shipping_address_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','shipping_address')">
                  {{ form['shipping_address'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item label="审核状态" name="examine_state">
                <uni-data-select
                    v-model="form['examine_state']"
                    :localdata="list_examine_state"
                    v-if="user_group === '管理员' || (form['examine_state'] && $check_examine()) || (!form['examine_state'] && $check_examine())"
                ></uni-data-select>
                <text v-else>{{form["examine_state"]}}</text>
              </uni-forms-item>
              <uni-forms-item label="审核回复" name="examine_reply">
                <uni-easyinput type="text" placeholder="请输入审核回复" v-model="form['examine_reply']"
                               v-if="user_group === '管理员' || (form['examine_reply'] && $check_examine()) || (!form['examine_reply'] && $check_examine())" />
                <!-- 仅查看 -->
                <text v-else>{{form["examine_reply"]}}</text>
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
          list_whether_to_identify: [],
                                      // 鉴定费用选项列表
          list_appraisal_fees: [],
                                                                    // 用户列表
            list_user_user_name: [],
                        // 用户组
            group_user_user_name: "",
                                          // 取货方式选项列表
          list_pickup_method: [],
                                                                                              list_examine_state:[{value:"未审核",text:"未审核"},{value:"已通过",text:"已通过"},{value:"未通过",text:"未通过"}],
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
            url: _self.$fullUrl('/api/appointment_order/upload?'),
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
            url: _self.$fullUrl('/api/appointment_order/upload?'),
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
            /**
     * 获取普通用户用户组
     */
    async get_group_user_user_name() {
      this.form["user_name"] = this.user.user_id;
      var json = await this.$get("~/api/user_group/get_obj?name=普通用户");
      if(json.result && json.result.obj){
        this.group_user_user_name = json.result.obj;
        this.get_user_session_user_name(this.form['user_name'])
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
            
            /**
     * 获取取货方式列表
     */
    async get_list_pickup_method() {
          ['线下取货','线上发货'].map((o) => this.list_pickup_method.push({value:o,text:o}));
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

  },
  created() {
                                                    this.get_list_user_supplier_user();
                                                    this.get_list_whether_to_identify();
                this.get_list_appraisal_fees();
                            this.get_list_user_user_name();
            this.get_group_user_user_name();
                    this.get_list_pickup_method();
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
