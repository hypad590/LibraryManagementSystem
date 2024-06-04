const form = document.getElementById('userForm');
const surNameInp = document.getElementById('surName');

form.addEventListener('submit',, async (event) )=>{
    event.preventDefault();

    const surName = surNameInp.value;

    try{
        const response = await fetch('/user/${surname}');

        if(!response.ok){
            throw new Error('HTTP error! status: ${response.status}');
        }

        const userData = await response.json();

        console.log('User retrieved:', userData);
    }catch(error){
        console.error('Error fetching user:', error);
    }
}