const array = [{name: 'A', values: [1, 1, 1]}, {name: 'B', values: [2, 2, 2]}, {name: 'C', values: [3, 3, 3]}]
let index = array.findIndex(item => item.name === null);
index = index !== -1 ? index : array.findIndex(item => item.name === 'B');
console.log(index);
