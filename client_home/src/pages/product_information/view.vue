<template>
  <view>
    <view class="container diy_view">
      <view>
        <view>
          <view class="">
            <uni-forms :modelValue="form"  v-if="is_view()">

              <uni-forms-item v-if="$check_field('get','commodity_map') || ($check_field('add','commodity_map') || $check_field('set','commodity_map'))" label="商品图" name="commodity_map">
                    <!-- 修改权限 -->
                <view class="diy_field diy_img" v-if="form['commodity_map'] && $check_field('set','commodity_map')">
                  <image v-if="disabledObj['commodity_map_isDisabled']" :src="$fullUrl(form['commodity_map'])" />
                  <image v-if="!disabledObj['commodity_map_isDisabled']" :src="$fullUrl(form['commodity_map'])" @click="change_img('commodity_map')" />
                </view>
                <!-- 添加权限 -->
                <view class="diy_field diy_img" v-else-if="!form['commodity_map'] && $check_field('add','commodity_map')">
                  <view v-if="disabledObj['commodity_map_isDisabled']" class="btn_add_img">
                    <text>+</text>
                  </view>
                  <view v-if="!disabledObj['commodity_map_isDisabled']" class="btn_add_img" @click="change_img('commodity_map')">
                    <text>+</text>
                  </view>
                </view>
                <!-- 查询权限 -->
                <view class="diy_field diy_img" v-else-if="$check_field('get','commodity_map')">
                  <image :src="$fullUrl(form['commodity_map'])" />
                </view>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','trade_name') || ($check_field('add','trade_name') || $check_field('set','trade_name'))" label="商品名称" name="trade_name">
                            <uni-easyinput type="text" v-model="form['trade_name']" v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','trade_name')) || (!form['product_information_id'] && $check_field('add','trade_name'))" :disabled="disabledObj['trade_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','trade_name')">
                  {{ form['trade_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','product_type') || ($check_field('add','product_type') || $check_field('set','product_type'))" label="商品类型" name="product_type">
                    <uni-data-select
                  v-model="form.product_type"
                  :localdata="list_product_type"
                  :clear="!disabledObj['product_type_isDisabled']"
                  :disabled="disabledObj['product_type_isDisabled']"
                  v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','product_type')) || (!form['product_information_id'] && $check_field('add','product_type'))"
                ></uni-data-select>
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','product_type')">
                  {{ form['product_type'] }}
                </text>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','product_parameters') || ($check_field('add','product_parameters') || $check_field('set','product_parameters'))" label="商品参数" name="product_parameters">
                            <uni-easyinput type="text" v-model="form['product_parameters']" v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','product_parameters')) || (!form['product_information_id'] && $check_field('add','product_parameters'))" :disabled="disabledObj['product_parameters_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','product_parameters')">
                  {{ form['product_parameters'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','specifications') || ($check_field('add','specifications') || $check_field('set','specifications'))" label="规格" name="specifications">
                            <uni-easyinput type="text" v-model="form['specifications']" v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','specifications')) || (!form['product_information_id'] && $check_field('add','specifications'))" :disabled="disabledObj['specifications_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','specifications')">
                  {{ form['specifications'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','stock') || ($check_field('add','stock') || $check_field('set','stock'))" label="库存" name="stock">
                    <uni-data-select
                  v-model="form.stock"
                  :localdata="list_stock"
                  :clear="!disabledObj['stock_isDisabled']"
                  :disabled="disabledObj['stock_isDisabled']"
                  v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','stock')) || (!form['product_information_id'] && $check_field('add','stock'))"
                ></uni-data-select>
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','stock')">
                  {{ form['stock'] }}
                </text>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','price') || ($check_field('add','price') || $check_field('set','price'))" label="价格" name="price">
                            <uni-easyinput type="text" v-model="form['price']" v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','price')) || (!form['product_information_id'] && $check_field('add','price'))" :disabled="disabledObj['price_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','price')">
                  {{ form['price'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','supplier_user') || ($check_field('add','supplier_user') || $check_field('set','supplier_user'))" label="供货商用户" name="supplier_user">
                    <uni-data-select
                  id="form_supplier_user"
                  v-model="form['supplier_user']"
                  :localdata="list_user_supplier_user"
                  :clear="!disabledObj['supplier_user_isDisabled']"
                  :disabled="disabledObj['supplier_user_isDisabled']"
                  v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','supplier_user')) || (!form['product_information_id'] && $check_field('add','supplier_user'))"
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
                            <uni-easyinput type="text" v-model="form['supplier_name']" v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','supplier_name')) || (!form['product_information_id'] && $check_field('add','supplier_name'))" :disabled="disabledObj['supplier_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','supplier_name')">
                  {{ form['supplier_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','product_introduction') || ($check_field('add','product_introduction') || $check_field('set','product_introduction'))" label="商品介绍" name="product_introduction">
                    <uni-easyinput type="textarea" v-model="form['product_introduction']" v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','product_introduction')) || (!form['product_information_id'] && $check_field('add','product_introduction'))" :disabled="disabledObj['product_introduction_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','product_introduction')">
                  {{ form['product_introduction'] }}
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
                    "price":  0 , // 价格
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
                                                    "supplier_user_isDisabled": false,
                                "supplier_name_isDisabled": false,
                                "product_introduction_isDisabled": false,
                                  },
                                                              // 商品类型选项列表
          list_product_type: [],
                                                                              // 库存选项列表
          list_stock: [],
                                                                    // 用户列表
            list_user_supplier_user: [],
                        // 用户组
            group_user_supplier_user: "",
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
            url: _self.$fullUrl('/api/product_information/upload?'),
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
            url: _self.$fullUrl('/api/product_information/upload?'),
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
     * 获取商品类型列表
     */
    async get_list_product_type() {
              var json = await this.$get("~/api/product_type/get_list?");
      if(json.result && json.result.list){
        json.result.list.map((o) => this.list_product_type.push({value:o.product_type,text:o.product_type}));
      }
      else if(json.error){
        console.error(json.error);
      }
        },
        
            
            
            /**
     * 获取库存列表
     */
    async get_list_stock() {
          ['1','不限'].map((o) => this.list_stock.push({value:o,text:o}));
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
            /**
     * 获取供货商用户组
     */
    async get_group_user_supplier_user() {
      this.form["supplier_user"] = this.user.user_id;
      var json = await this.$get("~/api/user_group/get_obj?name=供货商");
      if(json.result && json.result.obj){
        this.group_user_supplier_user = json.result.obj;
        this.get_user_session_supplier_user(this.form['supplier_user'])
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

  },
  created() {
                        this.get_list_product_type();
                                this.get_list_stock();
                            this.get_list_user_supplier_user();
            this.get_group_user_supplier_user();
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
