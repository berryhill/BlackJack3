$(document).ready(function(){
	console.log('connected');
    var w = $(window).width();
    var h = $(window).height();
    // $('#woo').width(w);
    $('#table').width(w);
    $('#table').height(h);
     
    var cardArray = ['A','2','3','4','5','6','7','8','9','10','J','Q','K'];
    var suiteArray = ['C','H','S','D'];
    var dealt = [];
    var userScore = 0;
    var dealerScore = 0;
	// Tux image is from creative commons, I didn't create it!

	var s = Snap("#table");
	var d = Snap.load('deck.svg', function (f){

	});
	var tabl = Snap.load("table2.svg", 
		function ( loadedFragment ) {
	        var tab = loadedFragment.select('#table');

        	// Add SVG to body
	        s.append( loadedFragment );
	        // // Scale svg up
	        tab.attr({ transform : 'scale(4)'});
		});

	var deck = Snap.load("deck.svg", function (f){
		var deckStack = f.select("#deckStack")
		var d3 = f.select('#SK')
		// deckStack.drag();
		s.append(f)
	    deckStack.attr({transform: 'matrix(0.25,0,0,0.25,599.0356,-78.3639)'})

	    // Random Number Generator


		function randomGen(){
	        var randomCard = cardArray[Math.floor(cardArray.length * Math.random())];
	        var randomSuite = suiteArray[Math.floor(suiteArray.length * Math.random())];
	        var randomPick = randomSuite + randomCard;
	        console.log(randomPick);
	        dealt.push(randomPick)
	        var cardGen = Snap('#'+ randomPick )
	        return randomPick;
	    }


	    var cardGen = Snap('#SK');
	    var userCardCount = 0;
	    var dealerCardCount = 0;


	    $('#deckStack').click(function(){
	    	if (userScore > 21){
	    		$('#deckStack').unbind('click');

	    	} else{
		    	var randomPick = randomGen();
		    	var par = $('#deckStack');
		    	var cardGen = Snap('#'+ randomPick )
		    	// var clone = cardGen.clone();
		    	dealerLayout(cardGen);
		    	scoreKeeper(randomPick);
		    	dealerCardCount++;		
	    	}
    	})

    	$('#deal').click(deal);

    	function deal(){
    		$('#deal').unbind('click')
    		for(var i = 0; i < 2; i++){
    			var randomPick = randomGen();
    			var randomPick2 = randomGen();
		    	var cardGen = Snap('#'+ randomPick )
		    	var cardGen2 = Snap('#'+ randomPick2 )
		    	userLayout(cardGen);
		    	dealerLayout(cardGen2);
		    	userCardCount++;
		    	dealerCardCount++;
    		}
    	}


		function randomGen(){

	        var randomCard = cardArray[Math.floor(cardArray.length * Math.random())];
	        var randomSuite = suiteArray[Math.floor(suiteArray.length * Math.random())];
	        var randomPick = randomSuite + randomCard;
	        console.log(randomPick);
	        dealt.push(randomPick)
	        return randomPick;
	    }

	    function userLayout(cardGen){
	    	switch(userCardCount) {
			    case 0:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-982,1175)'}, 500, function(){
			    		cardGen.drag();
			    		console.log(userCardCount)
			    		
			    	})
			        break;
			    case 1:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-691,1175)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 2:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-1250,840)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 3:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-1150,840)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 4:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-1050,840)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 5:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-950,840)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 6:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-850,840)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 7:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-750,840)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 8:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-650,840)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 9:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-550,840)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 10:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-450,840)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 11:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-350,840)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 12:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-250,840)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    default:
			        console.log('default')
			}
	    }

	    function dealerLayout(cardGen){
	    	switch(dealerCardCount) {
			    case 0:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-982,0)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 1:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-691,0)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 2:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-1250,400)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 3:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-1150,400)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 4:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-1050,400)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 5:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-950,400)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 6:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-850,400)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 7:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-750,400)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 8:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-650,400)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 9:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-550,400)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 10:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-450,400)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 11:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-350,400)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    case 12:
			        cardGen.animate({transform: 'matrix(1,0,0,1,-250,400)'}, 500, function(){
			    		cardGen.drag();
			    	})
			        break;
			    default:
			        console.log('default')
			}
	    }

	    function scoreKeeper(randomPick){
	    	if(randomPick[1] && randomPick[2]){
	    		console.log('workin')
	    		userScore = userScore + 10;
	    	} else if( randomPick[1] == 'J'){
	    		userScore = userScore + 10;	    		
	    	} else if( randomPick[1] == 'Q'){
	    		userScore = userScore + 10;	    		
	    	} else if( randomPick[1] == 'K'){
	    		userScore = userScore + 10;
	    	} else if( randomPick[1] == 'A'){
	    		if ((userScore + 10) > 21){
	    			userScore = userScore + 1;
	    		} else{
	    			userScore = userScore + 10;
	    		}
	    	} else {
	    		userScore = userScore + parseInt(randomPick[1])
	    	}
	    	console.log(userScore);

	    	if(userScore > 21){
	    		$('#score').text('BUST!')
	    	}else if (userScore == 21){
	    		$('#score').text('21!!!!!!')
	    		$('#deckStack').unbind('click');
	    	} 
	    	else {
	    		$('#score').text(userScore);
	    	}

	    }

	})


})


