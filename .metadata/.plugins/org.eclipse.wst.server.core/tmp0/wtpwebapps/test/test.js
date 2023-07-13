let switchBtn = document.getElementsByTagName('button')[0];
//表示・非表示を切り替える要素を取得
let box = document.getElementById('search_results');

//styleのdisplayを変更する関数
let changeElement = (el) => {

	if (el.style.display == 'none') {
		el.style.display = 'block';
	} else {
		el.style.display = 'none';
	}

}

//上記関数をボタンクリック時に実行
switchBtn.addEventListener('click', () => {
	changeElement(box);
}, false);

//非同期処理

