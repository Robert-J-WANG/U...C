
// JavaScript functions for Shopping Cart on the separate page (for the website)

//Created by Elena Shuvaeva

var nextItem = 0; //The index of next ietm to be added
var currentCart = new Array(); //This array contains the current items in the cart

// global object
    var store;

function load_data() {
// load persistent store after the DOM has loaded
      store = new Persist.Store('My Application');
    }
function loadXMLFile(xmlFile)
{
	if (window.XMLHttpRequest)
	{// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	//Load the XML file and return an XML object
	xmlhttp.open("GET", xmlFile, false);
	xmlhttp.send();
	return (xmlhttp.responseXML);
}

function displayBooks()
{
	//Load the XML file that contains the information for all the books
	xmlDoc=loadXMLFile("books.xml");

    //Construct a table that contains the key information for all the books
	txt="<table border='0px' id='tblBook' cellpadding='3px' cellspace='0px'>";
	txt+="<tr><th>Item</th><th>Title</th><th>Author</th><th>Price</th><th>Add</th></tr>";
	
	//Retrieve all the BOOK elements from the XML file
    books=xmlDoc.documentElement.getElementsByTagName("BOOK");
    for (i=0;i<books.length;i++)
    {
      txt+="<tr>";
      
	  txt+="<td align='left'>" + i + "</td>";
	  bookChildren=books[i].getElementsByTagName("TITLE");
      txt+="<td align='left' id='title"+ i +"'>" + bookChildren[0].firstChild.nodeValue + "</td>"; 
         
      bookChildren=books[i].getElementsByTagName("AUTHOR");
      txt+="<td align='left'>" + bookChildren[0].firstChild.nodeValue + "</td>";
	  
	  bookChildren=books[i].getElementsByTagName("PRICE");
      txt+="<td align='left' id='price"+ i +"'>" + bookChildren[0].firstChild.nodeValue + "</td>";
	  
	  txt+="<td align='right'><img src='book-icon.jpg'/></td>";
	  txt+="<td align ='right'><button type='button' id='bntAddTocart' onclick='addToCart(" + i + ")'>Add to Cart</button>"  + "</td>";

      txt=txt + "</tr>";
    }
    txt+="</table>";
	
	//Display book table in <div id="txtBookInfo">
    document.getElementById("txtBookInfo").innerHTML=txt;
}

function addToCart(selectedItem)
{
	var addedIndex = -1;
	
	//Check if the selected item has been added once
	for (i=0;i<nextItem;i++)
	{
		if (currentCart[i][0]==selectedItem)
		{
			//The selected item has been added once, record the index
			addedIndex = i;
			break; //stop looping
		}
	}
	
	//If the selected item has not been added, add a new item to the shopping cart, otherwise, simply increase the quantity for the item by one,  

	if (addedIndex == -1)
	{
	  //Create a new item in the shopping cart
	  currentCart[nextItem] = new Array();
	  
	  //Put the item details into the shopping cart
	  currentCart[nextItem][0] = selectedItem;
	  currentCart[nextItem][1] = document.getElementById("title" + selectedItem).innerHTML;
	  currentCart[nextItem][2] = document.getElementById("price" + selectedItem).innerHTML;
	  currentCart[nextItem][3] = 1; //set the quantity
	  
	  //Get ready to add next item
	  nextItem += 1;
	}
	else
	{
		currentCart[addedIndex][3] += 1;
	}
	
	//Saving cart in Json 
	
	var currentCartJson = JSON.stringify(currentCart);
	store.set('shopping_cart', currentCartJson);
	store.save();
}

function displayCart()
{
   //Construct shopping cart table heading
   txt="<table id='tblCart' border='5px' cellpadding='1px' cellspacing='0px' align='center' style='margin:0px;border:#666 solid;'>";
   txt+="<tr><th>Item</th><th>Title</th><th>Price</th><th>Quantity</th></tr>";
    
   totalCost = 0;
	
	
	if (store == undefined)
	{
		store = new Persist.Store('My Application');
	}
    // get value from store and prompt user
    store.get('shopping_cart', function(ok, val)
		{
			
			if (ok)
			{
				
				var currentCartJson = val;
				currentCart=JSON.parse(currentCartJson);
				nextItem = currentCart.length;
				//Construct shopping cart table body
				for (i=0;i<nextItem;i++)
				{
				  txt+="<tr>";
				  
				  txt+="<td align='left'>" + currentCart[i][0] + "</td>"; 
				  txt+="<td align='left'>" + currentCart[i][1] + "</td>"; 
				  txt+="<td align='left'>" + currentCart[i][2] + "</td>"; 
				  txt+="<td align='right'>" + currentCart[i][3] + "</td>"; 
				  
				  totalCost += currentCart[i][2] * currentCart[i][3];
				 
				  txt=txt + "</tr>";
				}
			   
			   //Display the total cost
			   txt+="<td align='center' colspan='4' style='color:#900;'> Total Cost: " + parseFloat(totalCost).toFixed(2) + "</td>";
			   
			   //Close shopping cart table
			   txt+="</table>";
			   
			   //Display shopping cart table in <div id="txtCart">
			   document.getElementById("txtCart").innerHTML=txt;
				
			}
		}
	);
	
	
}

// You need to modify the code below to make it work. Think about how to clear your persist store 
function clearCart()
{
	//Reinitialise the current item array
	nextItem = 0;
    currentCart = new Array();
	
    //Add some code here..........;
	
	//Refresh the shopping cart
	displayCart();
}

function checkOut()
{
	
	//Construct XML string
	txt="<ITEMS>";
	
	//Loop through the shopping cart
	for (i=0;i<nextItem;i++)
    {
		txt=txt+"<ITEM>";
		txt=txt+"<TITLE>" + currentCart[i][1] + "</TITLE>";
		txt=txt+"<PRICE>" + currentCart[i][2] + "</PRICE>";
		txt=txt+"<QUTANTY>" + currentCart[i][3] + "</QUTANTY>";
		txt=txt+"</ITEM>";
	}
	txt=txt+"</ITEMS>";
    
	//Save the XML data into an XML object, which could be used by another pice of JavaScript code
	
	if (window.DOMParser)
	{
	  parser=new DOMParser();
	  xmlDoc=parser.parseFromString(txt,"text/xml");
	}
	else // Internet Explorer
	{
	  xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
	  xmlDoc.async=false;
	  xmlDoc.loadXML(txt);
	}
	
  //XML HTTP object
  if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  
  if (xmlhttp){
	  
  }

  //Send the XML string to server
  var url = "ProcesingOrder.php?XMLStr=" + txt;
  xmlhttp.open("GET", url, false);
  xmlhttp.send(null);

  if (totalCost <= 0){
	alert("Your Shopping Cart is Empty!");
  }
  else {
	alert("Thank You For Shopping with Us!");
  }

  //Clear cart
  clearCart();
}


