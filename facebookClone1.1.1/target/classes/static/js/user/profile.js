const profileImgElem = document.querySelector('#flexContainer .profile.w300.pointer');
const modalElem = document.querySelector('section .modal');
const modalCloseElem = document.querySelector('section .modal .modal_close');

//모든 no-main-profile 아이콘에 이벤트를 걸어준다.
//이벤트는 메인 이미지 변경처리
//querySelectorAll은 배열로 넘어와서 처리한다
const profileImgParentList = document.querySelectorAll('.profile-img-parent');
profileImgParentList.forEach(item => {
    const iElem = item.querySelector('i');
    if(iElem != null) {
        addIElemEvent(iElem);
    }
});

//메인이미지 바꾸기 아이콘에 이벤트 설정
function addIElemEvent(target) {
    target.addEventListener('click', () => {
        const iprofile = target.parentNode.dataset.iprofile;
        console.log(iprofile);
        changeMainProfile(iprofile);
    });
}

//메인 이미지 변경
function changeMainProfile(iprofile) {
    //get방식으로 날아감
    fetch(`/user/mainProfile?iprofile=${iprofile}`)
        .then(res => res.json())
        .then(myJson => {
            switch(myJson.result) {
                case 0:
                    alert('메인 이미지 변경에 실패하였습니다.');
                    break;
                case 1:
                    //새롭게 종들을 셋팅한다.
                    setMainProfileIcon(iprofile);

                    //헤더에있는 프로필 이미지 변경

                    //Section에있는 프로필 이미지 변경
                    const src = profileImgElem.src;
                    const frontScr = scr.substring(src.lastIndexOf("/") + 1);
                    profileImgElem.src = frontScr + myJson.img;

                    break;
            }
        });
}
                            //현재 mainProfile로 바뀐 iprofile값
function setMainProfileIcon(iprofile) {

    profileImgParentList.forEach(item => {

        item.innerHTML = '';

        const itemIprofile = item.dataset.iprofile;
        if(iprofile !== itemIprofile) {
            const iElem = document.createElement('i');
            iElem.className = 'no-main-profile pointer fas fa-bell';
            item.append(iElem);

            addIElemEvent(iElem);
        }
    });
}


//모달창 띄우기
profileImgElem.addEventListener('click', () => {
    modalElem.classList.remove('hide');
});

//모달창 닫기
modalCloseElem.addEventListener('click', () => {
    modalElem.classList.add('hide');

})