import { Layout, Menu, Breadcrumb } from 'antd';
import "antd/dist/antd.css";
import ListaPessoas from './components/ListaPessoas';

const { Header, Content, Footer } = Layout

function App() {
  return (
    <div>
      <Layout className="layout">
        <Header>
          <div className="logo">
            <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['1']}>
              <Menu.Item key="1">Home</Menu.Item>
            </Menu>
          </div>
        </Header>
        <Content style={{padding: '0 50px'}}>
          <div className="site-layout-content">
            <ListaPessoas></ListaPessoas>
          </div>
        </Content>
        <Footer style={{textAlign: 'center'}}>
          Vaccine App
        </Footer>
      </Layout>
    </div>
  );
}

export default App;
