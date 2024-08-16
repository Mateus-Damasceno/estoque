import { ProductDto } from './product.dto';

export interface CityDto {
  id: number;
  name: string;
  state: string;
  products: ProductDto[];
}
