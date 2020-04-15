package br.com.blackvagas.entrypoint;

import br.com.blackvagas.entrypoint.mapper.CompanyEntryPointMapper;
import br.com.blackvagas.entrypoint.model.CompanyModel;
import br.com.blackvagas.entrypoint.model.UserModel;
import br.com.blackvagas.factory.CompanyFactory;
import br.com.blackvagas.factory.UserFactory;
import br.com.blackvagas.usecase.CompanySaveUseCase;
import br.com.blackvagas.usecase.entity.Company;
import br.com.blackvagas.usecase.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static br.com.blackvagas.entrypoint.mapper.UserEntryPointMapper.from;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CompanySaveEndPointTest {

    @Mock
    private CompanySaveUseCase useCase;

    @Captor
    private ArgumentCaptor<Company> companyArgumentCaptor;

    private CompanySaveEndPoint endPoint;

    @Before
    public void setup(){
        endPoint = new CompanySaveEndPoint(useCase);
    }


    @Test
    public void saveUserTest(){
        //given
        CompanyModel companyModel = CompanyFactory.buildFakeModel();
        when(useCase.saveCompany(Mockito.any(Company.class))).thenReturn(CompanyEntryPointMapper.from(companyModel));

        //when
        ResponseEntity<CompanyModel> companyData = endPoint.saveEndPoint(companyModel);

        //then

        Assert.assertEquals(companyModel.getEmail(), companyData.getBody().getEmail());
        verify(useCase,times(1)).saveCompany(companyArgumentCaptor.capture());
        Assert.assertEquals(companyArgumentCaptor.getValue().getName(), companyModel.getName());
    }


}
