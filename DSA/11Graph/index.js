// const arr=[];
// try{
//     arr.push('try');
//     throw new Error();
    
// }
// catch(e){
//     arr.push('catch');
    
// }finally{
    
//     arr.push('finally');
// };
// console.log(arr);

// const mySet = new Set();
// mySet.add(1)
// mySet.add(1)
// mySet.add('a')
// mySet.add('a')
// mySet.add(undefined)
// mySet.add(undefined)
// mySet.add({prop:true})
// mySet.add({prop:true})
// console.log('size:',mySet.size)

// let x = 'fog';
// function first(){
//     console.log(x);
// };
// x= 'dog';
// function second(){
//     let x = 'log';
//     first();
// };
// second();

// function myFunction(y1,y2,...y3){
//     const[x1,...[result]]=y3;
//     console.log(result);
// }
// const myArray =['rock','paper','scissor','liz','spock'];
// myFunction(...myArray);


// if( typeof TEST_ENV!== undefined){
//     console.log('In test')
// }

// const obj={
//     prop:1
// }
// console.log(obj.prop)
// Object.defineProperty(obj,'prop',{
//     writable:false,
//     value:2
// })
// console.log(obj.prop)
// obj.prop = 3
// console.log(obj.prop)

// let myArray =[1,2]
// myArray.customProperty = true;

// for(const ind in myArray){
    
//     console.log(elem)
// }

// function* gen1(){
//     console.log(yield 1);
//     console.log(yield 2);
//     console.log(yield 3);
// }
// const iterator = gen1()

// console.log(iterator.next('a').value)
// console.log(iterator.next('b').value)
// console.log(iterator.next('c').value)

// class Apple{
//     constructor(){
//         this.type ='apples'
//         this.variety =['gra','fuj','pin'];
//     }
//     logVar(callback){
//         this.variety.forEach(function(el){

//             console.log(`we have ${ele}`);
//         }
//     };
// }
// const apple = new Apple();
// apple.logVar();

// const a =0;
// const b='';
// const c= ['h'];

// const out =!!(a||b||c||d);

async function apiCall(){
    return new Promise(resolve=>{
        setTimeout(()=>{ resolve('b')} ,50);

    });
}
async function logger(){
    setTimeout(()=> console.log('a'),10);
    console.log(await apiCall());
    console.log('c');
}
logger()
