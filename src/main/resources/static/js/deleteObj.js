const form = document.getElementById('deleteId');
const surNameInp = document.getElementById('surName');
const bookNameInp = document.getElementById('name');

form.addEventListener('submit', async (event) =>{
    event.preventDefault();

    const surName = surNameInp.value;

    const bookName = bookNameInp.value;

    try{
        const [response, response0] = await Promise.all([
            fetch(`/api/v2/deleteUser/${surName}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
            },
            body: JSON.stringify({surName})
        }),
        fetch(`/api/v1/deleteBook/${bookName}`,{
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({bookName})
        })
    ]);

        if (!response.ok && !response0.ok) {
            throw new Error(`HTTP error! status: ${response.status} ${response0.status}`);
        }
        console.log('Response data:', await response.json(), await response0.json());
    }catch(error){
        console.error('Error fetching name', error);
    }
});
