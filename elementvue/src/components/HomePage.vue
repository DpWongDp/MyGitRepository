<template>
    <div>
      <el-carousel :interval="4000" type="card" height="250px">
        <el-carousel-item v-for="item in images" :key="item">
          <el-image
            style="height: 250px; width:350px;"
            :src= item
            fit="contain"></el-image>
        </el-carousel-item>
      </el-carousel>
    </div>
</template>

<script>
    import image1 from "../assets/gy.jpg";
    import image2 from "../assets/zf.jpg";
    import image3 from "../assets/zy.jpg";
    import image4 from "../assets/mc.jpg";
    import image5 from "../assets/hz.jpg";

    export default {
        name: "HomePage",
        data(){
          return {
            images:[image1,image2,image3,image4,image5]
          }
        }
    }
</script>

<style scoped>

</style>
