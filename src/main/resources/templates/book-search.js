const form = document.getElementById('bookForm');
const bookNameInp = document.getElementById('bookName');

form.addEventListener('submit', async (event) =>{
    event.preventDefault();

    const bookName = bookNameInp.value;

    try{
        const response = await fetch('/book/${bookName}');

        if(!response.ok){
            throw new Error('HTTP error! status: ${response.status}');
        }

        const bookData = await response.json();

        console.log('Book retrieved:', bookData);
    }catch(error){
        console.error('Error fetching book:', error);
    }
})