import React from 'react'

class Todo extends React.Component{
    render(){
        return(
            <div className="todo">
                <h1 class="todo-header">8월 30일 목요일</h1>
                <div class="card-body">
                    <p class="card-text">저녁 먹기</p>
                </div>
            </div>
        )
    }
}

export default Todo