import React, {useState} from 'react';

export default function MaximalUserNumber({changeCount}) {
    
    const [count, setCount] = useState(2);

    const decreaseCounter = (e) =>{
        e.preventDefault();
        if (count > 2){     
            setCount(prevCount => prevCount - 1);
            changeCount(count-1);
        }
    }

    const increaseCounter = (e) =>{   
        e.preventDefault();   
        if (count < 8){        
            setCount(prevCount => prevCount + 1);
            changeCount(count+1);
        }
    }
  
    return (
    <>
        Maximal Player Number
        <button onClick={decreaseCounter}>-</button>
        <span id="maximalUserNumber" >{count}</span>
        <button onClick={increaseCounter}>+</button>
    </>
  )
}
