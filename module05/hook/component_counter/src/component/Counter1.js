import {useIncrement} from "../hooks/useIncrement";
import React from "react";

function Counter1() {
    const [count, setCount] = useIncrement(0)
    return(
       <>
            <p>Count: {count}</p>
            <button onClick={()=> setCount(1)}>Add 1</button>
       </>
    )
}
export default Counter1;