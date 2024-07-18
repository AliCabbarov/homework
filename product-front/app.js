const tableBody = document.querySelector('tbody')
const addProduct = document.querySelector('.add-product')

addProduct.addEventListener(('click'),()=>{
  window.open('./product-post.html','_self')
})
async function getData(){
  const response = await fetch('http://localhost:8080/products');
  return await response.json()
}

getData().then((data)=>fillTable(data))

function fillTable(data){
  console.log(data)
 data.forEach((element)=>{
   tableBody.innerHTML+=`
  <tr>
        <td>${element.id}</td>
        <td><img src=${element.productDetail.imageUrl} alt=""></td>
        <td>${element.name}</td>
        <td>${element.description}</td>
        <td>${element.price}</td>
        <td>${element.quantity}</td>
        <td><div style="width: 20px; height: 20px;background-color:${element.productDetail.color}"></div></td>
      </tr>
  `
 })
}


