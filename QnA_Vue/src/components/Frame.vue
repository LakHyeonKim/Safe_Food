<template>
    <div>
        <router-view/>
    </div>
</template>

<script>
    export default {
        mounted() {
            this.$router.push("/boards");
        }
    }
</script>

<style lang="scss" scoped>
</style>