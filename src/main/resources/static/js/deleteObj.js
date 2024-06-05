const form = document.getElementById('deleteId');
const surNameInp = document.getElementById('surName');
const bookNameInp = document.getElementById('name');

form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const fetchPromises = [];

    let bookName = '';
    let surName = '';

    if (bookNameInp != null) {
        bookName = bookNameInp.value;
    }
    if (surNameInp != null) {
        surName = surNameInp.value;
    }

    try {
        if (surName) {
            fetchPromises.push(
                fetch(`/api/v2/deleteUser/${surName}`, {
                    method: 'DELETE',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({ surName })
                })
            );
        }

        if (bookName) {
            fetchPromises.push(
                fetch(`/api/v1/deleteBook/${bookName}`, {
                    method: 'DELETE',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({ bookName })
                })
            );
        }

        const responses = await Promise.all(fetchPromises);

        responses.forEach(async (response) => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            console.log('Response data:', await response.json());
        });

    } catch (error) {
        console.error('Error fetching name', error);
    }
});