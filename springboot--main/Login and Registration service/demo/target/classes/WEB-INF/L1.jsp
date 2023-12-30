<style>
form{
  background-color : aqua;
  width : 450px
  height : 480px;
  border-color: black;
  border-width:40px;
  top: 20%
  border-style : bold;
  
}

</style>


<div>
<form action="/Login", method="post">
<div> username: <input type: "text", value="",name="username"</div>
<div><br></div>

<div> Password: <input type: "text", value="",name="Password"</div>
<div><br></div>

<div><input type: "Button", value="login",name="lbutton"</div>
<div><br></div>

<div><input type: "Button", value="Registration", onclick=gotoregister(), name="Password"</div>
<div><br></div>

</form>
</div>

<script type= "text/javascript";
function gotoregister(){
alert("going to register window")
window.loaction.href('/register')
}
</script>
