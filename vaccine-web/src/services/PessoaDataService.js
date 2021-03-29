import axios from 'axios';

const API_URL = 'http://localhost:8080/'

class PessoaDataService{

    retrieveAllPessoas() {
        return axios.get(`${API_URL}pessoas`);
    }

    updatePessoa(codigo, pessoa){
        return axios.put(`${API_URL}pessoas/${codigo}`, pessoa);
    }
}

export default new PessoaDataService();