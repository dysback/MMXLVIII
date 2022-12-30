import './App.css';
import React from 'react';


class Table extends React.Component {

  constructor(){
    super();
    this.state={
        count :0,
        table : [['','','',''], ['','','',''], ['','','',''], ['','','','']]
    };
    this.StartGame=this.StartGame.bind(this);
  }
  
  StartGame(){
    fetch("http://localhost:8080/start-game")
    .then(response => response.text())
    .then(data => {
      console.log("SG: ",JSON.parse(data));
      this.setState(
        { table: JSON.parse(data) }
        )
    })

    //this.setState({count : this.state.count +1});
  }

  MoveUp = () => {
    fetch("http://localhost:8080/move-up")
    .then(response => response.text())
    .then(data => {
      console.log("SG: ",JSON.parse(data));
      this.setState(
        { table: JSON.parse(data) }
        )
    })
  }

  MoveDown = () => {
    fetch("http://localhost:8080/move-down")
    .then(response => response.text())
    .then(data => {
      console.log("SG: ",JSON.parse(data));
      this.setState(
        { table: JSON.parse(data) }
        )
    })
  }

  MoveLeft = () => {
    fetch("http://localhost:8080/move-left")
    .then(response => response.text())
    .then(data => {
      console.log("SG: ",JSON.parse(data));
      this.setState(
        { table: JSON.parse(data) }
        )
    })
  }
  
  MoveRight = () => {
    fetch("http://localhost:8080/move-right")
    .then(response => response.text())
    .then(data => {
      console.log("SG: ",JSON.parse(data));
      this.setState(
        { table: JSON.parse(data) }
        )
    })
  }
  
  HandleKeyPress = (e) => {
    console.log("E: ", e);
    switch(e.code) {
      case "ArrowRight":
        this.MoveRight();
        break;
      case "ArrowLeft":
        this.MoveLeft();
        break;
      case "ArrowDown":
        this.MoveDown();
        break;
      case "ArrowUp":
        this.MoveUp();

    }
  }

  render() {
    console.log("R:", this.state.table);
    return (
      <div className="App" onKeyDown={this.HandleKeyPress}>
        <table id="table">
          <tbody>
            { this.state.table.map((v, k) => {
              return (<tr> 
                { v.map((item, c) => {
                  return (<Cell number={item} />)
                })}
                </tr>) 
              })}
          </tbody>
        </table>
        <div  style={{clear: "left", width: "255px"}}>
          <div>
            <button  onClick={this.StartGame}>Start New Game</button>
          </div>
          <div>
            <button  onClick={this.MoveUp}>Up A</button>
          </div>
          <div>
            <button  onClick={this.MoveLeft}>&lt;- Left</button>
            <button  onClick={this.MoveRight}>Right -&gt;</button>
          </div>
          <div>
            <button  onClick={this.MoveDown}>Down V</button>
          </div>
        </div>
        
      </div>
    );
  }
}

const Cell = ({number}) => {
  var cls = "";
  switch(number) {
    case 2:
    case 4:
    case 8:
      cls = "App-lower";
      break;
    case 16:
    case 32:
    case 64:
      cls = "App-low";
      break;
    case 128:
    case 256:
    case 512:
      cls = "App-high";
      break;
    case 1024:
    case 2048:
    case 4096:
      cls = "App-higher";
      break;
    default:
      cls = "App-empty";

  }
  return <td class={cls} >{number == 0 ? "" : number}</td>;
}

export default Table;
