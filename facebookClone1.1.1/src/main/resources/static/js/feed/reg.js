const selectedImgListElem = document.querySelector('#selectedImgList');
const imgArrElem = document.querySelector("#imgArr");
    imgArrElem.addEventListener('change', ()=>{
    console.log('ddd');
    const reader = new FileReader();

    const fileList = imgArrElem.files;
    fileList.forEach( item =>{
        reader.readAsDataURL(item);
        const img = document.createElement('img');
    });
})