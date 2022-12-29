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
  
  render() {
    console.log("R:", this.state.table);
    return (
      <div className="App">
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
            <button  onClick={this.MoveUp}>Up</button>
          </div>
          <div>
            <button  onClick={this.MoveLeft}>Left</button>
            <button  onClick={this.MoveRight}>Right</button>
          </div>
          <div>
            <button  onClick={this.MoveDown}>Down</button>
          </div>
        </div>
        
      </div>
    );
  }
}

const Cell = ({number}) => {
  
  return <td>{number == 0 ? "" : number}</td>;
}

export default Table;
