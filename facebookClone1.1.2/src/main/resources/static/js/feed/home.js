const feedContainerElem = document.querySelector('#feedContainer')

//피드리스트 가져오기
function getFeedList(){
    fetch('list')
        .then(res => res.json())
        .then(myJson =>{
            makeFeedList(myJson);
        });
}

function makeFeedList(data){
    if(data.length == 0){return;}
    let beforeifeed = 0;
    data.forEach(item =>{
        if(beforeifeed !== item.ifeed){

            beforeifeed = item.ifeed;

            const itemCotainer = document.createElement('div');
            itemCotainer.classList.add('item');

            const topDiv = document.createElement('div');
            topDiv.innerHTML = `
            <div class="itemProfileCont">
                <img src="">
            </div>
            <div>
                <div></div>
                <div></div>
            </div>
        `;
        }

    });
}

getFeedList();