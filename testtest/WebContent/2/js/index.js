//  Inspired by Seven

//  http://dribbble.com/shots/1338859-Dribbble-Menu

// code by YoannHELIN http://yoannhelin.fr/

$(document).ready(function () {
  var show = 0;
  $('body').on('click','.profil',function() {
    if (show == 0) {
      $('ul').animate({
        'opacity':1
      },600);
      $('ul').animate({
        'margin-top':'35px'
      }, {
        duration: 800,
        queue: false
      });
      show = 1;
    }
    else {
      $('ul').animate({
        'opacity':0
      },600);
      $('ul').animate({
        'margin-top':'0'
      }, {
        duration: 800,
        queue: false
      });
      show = 0;
    }
  });
});