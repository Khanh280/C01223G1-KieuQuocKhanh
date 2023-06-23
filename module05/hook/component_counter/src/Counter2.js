import {useIncrement} from "./useIncrement";
import React from "react";

function Counter2() {
    const [count, setCount] = useIncrement(0)
    return (
        <>
            <p>Count: {count}</p>
            <button onClick={() => setCount(count+2)}>Add 2</button>
        </>
    )
}

export default Counter2;