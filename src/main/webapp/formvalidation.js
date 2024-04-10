function validationForm()
{
	//read the form data
	var proId=document.getElementById("proId").value;
	var proName=document.getElementById("proName").value;
	var proPrice=document.getElementById("proPrice").value;
	var proBrand=document.getElementById("proBrand").value;
	var proMadein=document.getElementById("proMadein").value;
	
	
	if(proId.trim()===""|| proName.trim()=== ""||
	proPrice.trim()===""|| proBrand.trim()===""||
	proMadein.trim() ===""){
		alert("All fileds must be filed out");
		return false;
	}
	if(parseFloat(proPrice)< 0)
	{
		alert("proprice must be an negative value");
		return false;
	}
	if(proName.length >50 || proBrand.length>50){
	alert("product name and proBrand must be less than 50 characters");
	return false;
	}
	//get the mfg &exp dates
	var proMfgDate=document.getElementById("proMfgDt").value;
	var proExpDate=document.getElementById("proExpDt").value;
	//convert into data formate
	var manufacturingDateObj=new Date(proMfgDate);
	var ExpiryDateObj=new Date(proExpDate);
	
	//check the validation of dates
	if(manufacturingDateObj > ExpiryDateObj)
	{
		alert("Manufacturing data cannot be greater than expriy data...");
		return false;
	}
	return true;
}