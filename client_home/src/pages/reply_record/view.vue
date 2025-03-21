<template>
  <view>
    <view class="container diy_view">
      <view>
        <view>
          <view class="">
            <uni-forms :modelValue="form"  v-if="is_view()">

              <uni-forms-item v-if="$check_field('get','supplier_user') || ($check_field('add','supplier_user') || $check_field('set','supplier_user'))" label="供货商用户" name="supplier_user">
                    <uni-data-select
                  id="form_supplier_user"
                  v-model="form['supplier_user']"
                  :localdata="list_user_supplier_user"
                  :clear="!disabledObj['supplier_user_isDisabled']"
                  :disabled="disabledObj['supplier_user_isDisabled']"
                  v-if="user_group === '管理员' || (form['reply_record_id'] && $check_field('set','supplier_user')) || (!form['reply_record_id'] && $check_field('add','supplier_user'))"
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
                            <uni-easyinput type="text" v-model="form['supplier_name']" v-if="user_group === '管理员' || (form['reply_record_id'] && $check_field('set','supplier_name')) || (!form['reply_record_id'] && $check_field('add','supplier_name'))" :disabled="disabledObj['supplier_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','supplier_name')">
                  {{ form['supplier_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','user_name') || ($check_field('add','user_name') || $check_field('set','user_name'))" label="用户名称" name="user_name">
                    <uni-data-select
                  id="form_user_name"
                  v-model="form['user_name']"
                  :localdata="list_user_user_name"
                  :clear="!disabledObj['user_name_isDisabled']"
                  :disabled="disabledObj['user_name_isDisabled']"
                  v-if="user_group === '管理员' || (form['reply_record_id'] && $check_field('set','user_name')) || (!form['reply_record_id'] && $check_field('add','user_name'))"
                ></uni-data-select>
                <uni-data-select
                  v-model="form['user_name']"
                  :localdata="list_user_user_name"
                  :clear="false"
                  :disabled="true"
                  v-else-if="$check_field('get','user_name')" id="user_name"
                ></uni-data-select>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','consultation_topic') || ($check_field('add','consultation_topic') || $check_field('set','consultation_topic'))" label="咨询主题" name="consultation_topic">
                            <uni-easyinput type="text" v-model="form['consultation_topic']" v-if="user_group === '管理员' || (form['reply_record_id'] && $check_field('set','consultation_topic')) || (!form['reply_record_id'] && $check_field('add','consultation_topic'))" :disabled="disabledObj['consultation_topic_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','consultation_topic')">
                  {{ form['consultation_topic'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','reply_content') || ($check_field('add','reply_content') || $check_field('set','reply_content'))" label="回复内容" name="reply_content">
                    <uni-easyinput type="textarea" v-model="form['reply_content']" v-if="user_group === '管理员' || (form['reply_record_id'] && $check_field('set','reply_content')) || (!form['reply_record_id'] && $check_field('add','reply_content'))" :disabled="disabledObj['reply_content_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','reply_content')">
                  {{ form['reply_content'] }}
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
      field: "reply_record_id",
      url_add: "~/api/reply_record/add?",
      url_set: "~/api/reply_record/set?",
      url_get_obj: "~/api/reply_record/get_obj?",
      url_upload: "~/api/reply_record/upload?",

      query: {
        "reply_record_id": 0,
      },

      form: {
            "supplier_user": 0, // 供货商用户
                    "supplier_name":  '', // 供货商名
                    "user_name": 0, // 用户名称
                    "consultation_topic":  '', // 咨询主题
                    "reply_content":  '', // 回复内容
                                "reply_record_id": 0, // ID
                
              },
          disabledObj:{
                        "supplier_user_isDisabled": false,
                                "supplier_name_isDisabled": false,
                                "user_name_isDisabled": false,
                                "consultation_topic_isDisabled": false,
                                "reply_content_isDisabled": false,
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
            url: _self.$fullUrl('/api/reply_record/upload?'),
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
            url: _self.$fullUrl('/api/reply_record/upload?'),
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
        bl = this.$check_action('/reply_record/table','add');
        console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
      }
      if(!bl){
        bl = this.$check_action('/reply_record/table','set');
        console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
      }
      if(!bl){
        bl = this.$check_action('/reply_record/view','add');
        console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
      }
      if(!bl){
        bl = this.$check_action('/reply_record/view','set');
        console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
      }
      if(!bl){
        bl = this.$check_action('/reply_record/view','get');
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
