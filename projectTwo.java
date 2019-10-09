// setup gui
var Options = function() {
};

var gui = new dat.GUI();
var ops = new Options();

let squares = [];
let series = [];
let gratio = 1.61803;
let startingvalue = 500;


function setup () {
  for(i = 0; i < 20; i++){
    series[i] = startingvalue / pow(gratio, i);
    squares[i] = new Square(0, 0, series[i]);
  }
  createCanvas(2 *(series[0] + series[1]),
              2 * series[0]);
  
  
}

function draw() {
  background(0);
  noFill();
  stroke(255);
  push();
  translate(series[0] + series[1], 0);
  render();
  pop();
  
  push();
  translate(series[0] + series[1], 2 * series[0])
  rotate(PI);
  render();
  pop();
  
  
  
}

function render() {
  push();
  squares[0].display();
  for(i = 1; i < squares.length; i++){
    translate(series[i - 1] + series[i], 0);
    rotate(HALF_PI);
    squares[i].display();
  }
  pop();
}

class Square {
  constructor(x, y, w){
    this.x = x;
    this.y = y;
    this.w = w;
  }
  display(){
    square(this.x, this.y, this.w);
      arc(this.x + this.w, 
        this.y + this.w, 
        this.w * 2, 
        this.w * 2, 
        PI, PI + HALF_PI);
  }
}
