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
    let imgDiv = null;

    data.forEach(item =>{
        if(beforeifeed !== item.ifeed){

            beforeifeed = item.ifeed;

            const itemCotainer = document.createElement('div');
            itemCotainer.classList.add('item');

            const topDiv = document.createElement('div');
            topDiv.classList.add('top')
            topDiv.innerHTML = `
            <div class="itemProfileCont">
                <img src="/pic/profile/${item.iuser}/${item.mainProfile}">
            </div>
            <div>
                <div>${item.writer}</div>
                <div>${item.location == null ? '' : item.location}</div>
            </div>
        `;

            imgDiv = document.createElement('div');

            itemCotainer.append(topDiv);
            itemCotainer.append(imgDiv);
            feedContainerElem.append(itemCotainer);

        }

        if(item.img != null){
            const img = document.createElement('img');
            img.src = `/pic/feed/${item.ifeed}/${item.img}`;
            imgDiv.append(img);
        }

    });
}

getFeedList();