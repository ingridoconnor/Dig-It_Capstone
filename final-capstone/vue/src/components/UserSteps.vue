<template>
  <div id="user-steps-container">
      <div class="steps">
        <div class="step">
            <h2 >1. Specify your garden dimensions</h2>
            <img id="step1img" class="imgsteps" src="../img/steps/1white.png" alt="">
            
        </div>
        <div class="step">
             <h2 class="steps">2. Add vegetable seedlings to your garden</h2>
            <img class="imgsteps" src="../img/steps/2.png" alt="">
           
        </div>
        <div class="step">        
            <h2>3. Generate a shopping list of garden supplies</h2>
            <img id="step3img" class="imgsteps" src="../img/steps/3.png" alt="">
            
        </div>
 <div class="step">        
                        <h2>4. And finally, <br> Life's a Garden...</h2>
                        <img class="imgsteps" src="../img/steps/4.png" alt="">

        </div>

      </div>

  </div>
</template>

<script>
export default {

}
</script>

<style>
    #user-steps-container {
        padding: 0px 30px;
    }
    
    #step1img {
        width: 100%;
    }
    
    #step3img {
        padding-left: 25px;
    }

    img {
        text-align: center;
        margin-top: 20px;
    }

    .steps {
        display: flex;
        color: #000000;
        text-align: center;
    }

    .step {
        /* background-color: #c1c56d; */
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: space-between;
        background-color: rgba(193,197,109, 0.7);
        border-style: solid;
        border-color: #c1c56d;
        border-radius: 10px;
        border-width: 10px;
        padding: 50px 0px 90px;
        margin: 10px;
        width: 23%;
    }


     .step > h2 {
   color: white;
   font-size: 2em;
    }
</style>