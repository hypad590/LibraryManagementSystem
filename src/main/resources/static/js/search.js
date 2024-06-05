const form = document.getElementById('userForm');
const surNameInp = document.getElementById('surName');

if(form == null){
    console.log('UserForm is null.Youre on books page')
}
else{
form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const surName = surNameInp.value;

    try {
        window.location.href = `/api/v2/user/${surName}`;
    } catch (error) {
        console.error('Error redirecting:', error);
    }
});
}

const bookForm = document.getElementById('bookForm');
const bookNameInp = document.getElementById('bookName');

if(bookForm == null){
    console.log('BookForm is null.Youre on users page');
}
else{
bookForm.addEventListener('submit', async (event) =>{
    event.preventDefault();

    const bookName = bookNameInp.value;

    try{
        const response = await fetch(`/api/v1/book/${bookName}`);
        if(!response.ok){
            throw new Error('HTTP error! status: ${response.status}');
        }

        const bookData = await response.json();
        console.log('Book retrieved:', bookData);
    }catch(error){
        console.error('Error fetching book:', error);
    }
});
}
