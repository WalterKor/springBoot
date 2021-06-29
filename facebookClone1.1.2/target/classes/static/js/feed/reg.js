const fileList = [];
const ctntElem = document.querySelector('#ctnt');
const selectImgArrElem = document.querySelector('#selectImgArr');
const btnUploadElem = document.querySelector('#btnUpload');
const displayImgListElem = document.querySelector('#displayImgList');

//글내용 변경시 keyup키보드를 땔때 keydown
ctntElem.addEventListener('keyup', ()=>{
    toggleBtnUpload();
});


//이미지들이 선택되면 fileList에 추가하기
selectImgArrElem.addEventListener('change', () => {
    toggleBtnUpload();
    const files = selectImgArrElem.files;
    for(let i=0; i<files.length; i++) {
        fileList.push(files[i]);
    }
    displaySelectedImgArr();
});

//fileList에 추가 된 이미지들 디스플레이하기
function displaySelectedImgArr() {
    displayImgListElem.innerHTML = '';

    for(let i=0; i<fileList.length; i++) {
        const item = fileList[i];
        const reader = new FileReader();
        reader.readAsDataURL(item);
        //로드 한 후
        reader.onload = () => {
            const img = document.createElement('img');
            img.addEventListener('click', () => {
                fileList.splice(i, 1);
                displaySelectedImgArr();
            });
            img.src = reader.result;
            displayImgListElem.append(img);
        };
    }
}
//등록버튼 활성화 비활성화하는거
function toggleBtnUpload(){

    if(ctntElem.value.length > 0 || fileList.length > 0){
        btnUploadElem.disabled = false;
    }else{
        btnUploadElem.disabled = true;
    }

}


//등록버튼 클릭시 (Ajax로 파일 업로드)
btnUploadElem.addEventListener('click', () => {

    const data = new FormData();
    //ctnt 담고
    if(ctntElem.value.length > 0){
        data.append('ctnt', ctntElem.value)
    }

    //사진 file담고
    if(fileList.length > 0){
        for(let i=0; i<fileList.length; i++){
            data.append('imgArr', fileList[i]);
        }
    }

    fetch('/feed/reg',{
        method: 'post',
        body: data
    })
        .then(res => res.json())
        .then(myJson =>{
            console.log(myJson);
        })
})